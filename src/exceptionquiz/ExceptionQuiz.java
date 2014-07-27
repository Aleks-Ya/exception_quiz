package exceptionquiz;

import exceptionquiz.excset.Jcp1ExcSet;
import exceptionquiz.question.QuestionRandomImpl;

/**
 * Основное приложение.
 */
public class ExceptionQuiz {
    public static void main(String[] args) {
        Jcp1ExcSet excSet = new Jcp1ExcSet();
        QuestionRandom generator = new QuestionRandomImpl(excSet);
        Inquirer inquirer = null;
        while (true) {
            Question question = generator.randomQuestion();
            inquirer.showQuestionText(question);
            String answer = inquirer.takeAnswerText();
            if (question.getAnswerText().equals(answer)) {
                inquirer.showRightAnswerText("RIGHT!");
            } else {
                inquirer.showRightAnswerText("MISTAKE: " + question.getAnswerText());
            }
        }
    }
}