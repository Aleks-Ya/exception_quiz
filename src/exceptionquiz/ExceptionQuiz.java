package exceptionquiz;

import exceptionquiz.answer.QuitAnswer;
import exceptionquiz.excset.Jcp1ExcSet;
import exceptionquiz.inquirer.ConsoleEnquirer;
import exceptionquiz.question.QuestionRandomImpl;
import exceptionquiz.statistic.StatisticImpl;

import java.util.Date;

/**
 * Основное приложение.
 * todo Исключить повтор вопроса в течение N заданий
 * todo Печатать версию приложения во время работы
 * todo Сохранять лог ошибок в файл для повторения и предлагать открыть после выхода
 * todo Длительность тренировки выводить в минутах и секундах
 */
public class ExceptionQuiz {
    private static final Statistic STATISTIC = new StatisticImpl();
    private static final Answer QUIT_ANSWER = new QuitAnswer();

    public static void main(String[] args) {
        STATISTIC.setStartTime(new Date());
        Jcp1ExcSet excSet = Jcp1ExcSet.getInstance();
        QuestionRandom generator = new QuestionRandomImpl(excSet);
        Inquirer inquirer = new ConsoleEnquirer(STATISTIC);
        inquirer.showInfoMessage("\n\nEXCEPTION QUIZ \nEnter \"q\" for exit\n");
        while (true) {
            Question question = generator.randomQuestion();
            inquirer.showQuestionText(question);
            String answer = inquirer.takeAnswerText(question.getPrompt());
            if (QUIT_ANSWER.isRight(answer)) {
                STATISTIC.setFinishTime(new Date());
                inquirer.showStatistic(STATISTIC);
                System.exit(0);
            } else if (question.getRightAnswer().isRight(answer)) {
                STATISTIC.incRightQuestions();
                inquirer.showRightAnswerText("RIGHT!");
            } else {
                STATISTIC.incMistakeQuestions();
                inquirer.showRightAnswerText("MISTAKE: " + question.getAnswerText());
            }
        }
    }
}