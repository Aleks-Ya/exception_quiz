package exceptionquiz;

import exceptionquiz.excset.Jcp1ExcSet;
import exceptionquiz.inquirer.ConsoleEnquirer;
import exceptionquiz.question.QuestionRandomImpl;
import exceptionquiz.statistic.StatisticImpl;

import java.util.Date;

/**
 * Основное приложение.
 * todo Исключить повтор вопроса в течение N заданий
 * todo Подсчитать время тренировки, количество вопросов, время на один вопрос.
 */
public class ExceptionQuiz {
    private static final Statistic STATISTIC = new StatisticImpl();

    public static void main(String[] args) {
        Jcp1ExcSet excSet = Jcp1ExcSet.getInstance();
        QuestionRandom generator = new QuestionRandomImpl(excSet);
        Inquirer inquirer = new ConsoleEnquirer(STATISTIC);
        while (true) {
            Question question = generator.randomQuestion();
            inquirer.showQuestionText(question);
            String answer = inquirer.takeAnswerText(question.getPrompt());
            if (question.getRightAnswer().isRight(answer)) {
                inquirer.showRightAnswerText("RIGHT!");
            } else {
                inquirer.showRightAnswerText("MISTAKE: " + question.getAnswerText());
            }
        }
    }
}