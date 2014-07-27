package exceptionquiz.inquirer;

import exceptionquiz.Inquirer;
import exceptionquiz.Question;

import java.io.Console;

/**
 * Опрос пользователя через консоль.
 */
public class ConsoleEnquirer implements Inquirer {
    private final Console console;

    public ConsoleEnquirer() {
        console = System.console();
        if (console == null) {
            throw new IllegalStateException("Console is not available. Run from console.");
        }
    }

    @Override
    public void showQuestionText(Question question) {
        console.printf("%s%n", question.getQuestionText());
    }

    @Override
    public String takeAnswerText(String prompt) {
        console.printf(prompt);
        return console.readLine();
    }

    @Override
    public void showRightAnswerText(String answerText) {
        console.printf("%s%n%n", answerText);
    }
}