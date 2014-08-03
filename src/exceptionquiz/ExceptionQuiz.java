package exceptionquiz;

import exceptionquiz.answer.QuitAnswer;
import exceptionquiz.excset.Jcp1ExcSet;
import exceptionquiz.formatter.StatisticFormatter;
import exceptionquiz.inquirer.ConsoleEnquirer;
import exceptionquiz.question.QuestionRandomImpl;
import exceptionquiz.statistic.StatisticImpl;

import java.util.Date;

/**
 * Основное приложение.
 * todo Исключить повтор вопроса в течение N заданий
 * todo Печатать версию приложения во время работы
 * todo Сохранять лог ошибок в файл для повторения и предлагать открыть после выхода
 */
public class ExceptionQuiz {
    private static final Answer QUIT_ANSWER = new QuitAnswer();

    public static void main(String[] args) {
        final Statistic statistic = new StatisticImpl();
        statistic.setStartTime(new Date());
        Jcp1ExcSet excSet = Jcp1ExcSet.getInstance();
        QuestionRandom generator = new QuestionRandomImpl(excSet);
        Formatter<Statistic> formatter = new StatisticFormatter();
        Inquirer inquirer = new ConsoleEnquirer(statistic, formatter);
        inquirer.showInfoMessage("\n\nEXCEPTION QUIZ \nEnter \"q\" for exit\n");
        while (true) {
            Question question = generator.randomQuestion();
            inquirer.showQuestionText(question);
            String answer = inquirer.takeAnswerText(question.getPrompt());
            if (QUIT_ANSWER.isRight(answer)) {
                statistic.setFinishTime(new Date());
                inquirer.showStatistic(statistic);
                System.exit(0);
            } else if (question.getRightAnswer().isRight(answer)) {
                statistic.incRightQuestions();
                inquirer.showRightAnswerText("RIGHT!");
            } else {
                statistic.incMistakeQuestions();
                inquirer.showRightAnswerText("MISTAKE: " + question.getAnswerText());
            }
        }
    }
}