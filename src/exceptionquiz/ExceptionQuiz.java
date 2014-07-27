package exceptionquiz;

import exceptionquiz.excset.Jcp1ExcSet;
import exceptionquiz.inquirer.ConsoleEnquirer;
import exceptionquiz.question.QuestionRandomImpl;

/**
 * Основное приложение.
 * todo Сделать "приглашение" у ввода в командной строке и писать в нем "package and class name"
 */
public class ExceptionQuiz {
    public static void main(String[] args) {
        Jcp1ExcSet excSet = Jcp1ExcSet.getInstance();
        QuestionRandom generator = new QuestionRandomImpl(excSet);
        Inquirer inquirer = new ConsoleEnquirer();
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