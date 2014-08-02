package exceptionquiz;

import exceptionquiz.answer.QuitAnswer;
import exceptionquiz.excset.Jcp1ExcSet;
import exceptionquiz.inquirer.ConsoleEnquirer;
import exceptionquiz.question.QuestionRandomImpl;
import exceptionquiz.statistic.StatisticImpl;

import static java.lang.System.out;

/**
 * Основное приложение.
 * todo Исключить повтор вопроса в течение N заданий
 * todo Подсчитать время тренировки, количество вопросов, время на один вопрос.
 */
public class ExceptionQuiz {
    private static final Statistic STATISTIC = new StatisticImpl();
    private static final Answer QUIT_ANSWER = new QuitAnswer();

    public static void main(String[] args) {
        out.println("Enter \"q\" for exit");
        Jcp1ExcSet excSet = Jcp1ExcSet.getInstance();
        QuestionRandom generator = new QuestionRandomImpl(excSet);
        Inquirer inquirer = new ConsoleEnquirer(STATISTIC);
        while (true) {
            Question question = generator.randomQuestion();
            inquirer.showQuestionText(question);
            String answer = inquirer.takeAnswerText(question.getPrompt());
            if (QUIT_ANSWER.isRight(answer)) {
                out.println("Finish");
                System.exit(0);
            } else if (question.getRightAnswer().isRight(answer)) {
                inquirer.showRightAnswerText("RIGHT!");
            } else {
                inquirer.showRightAnswerText("MISTAKE: " + question.getAnswerText());
            }
        }
    }
}