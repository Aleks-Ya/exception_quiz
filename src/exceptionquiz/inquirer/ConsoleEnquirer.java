package exceptionquiz.inquirer;

import exceptionquiz.Inquirer;
import exceptionquiz.Question;
import exceptionquiz.Statistic;

import java.io.Console;

/**
 * Опрос пользователя через консоль.
 */
public class ConsoleEnquirer implements Inquirer {
    private final Console console;
    private Statistic statistic;

    public ConsoleEnquirer() {
        console = System.console();
        if (console == null) {
            throw new IllegalStateException("Console is not available. Run from console.");
        }
    }

    public ConsoleEnquirer(Statistic statistic) {
        this();
        this.statistic = statistic;
    }

    @Override
    public void showQuestionText(Question question) {
        if (statistic != null) {
            console.printf("%d %s%n", statistic.getNextQuestionNumbers(), question.getQuestionText());
        } else {
            console.printf("%s%n", question.getQuestionText());
        }
    }

    @Override
    public String takeAnswerText(String prompt) {
        console.printf(prompt);
        String answer = console.readLine();
        if (statistic != null) {
            statistic.incFinishedQuestions();
        }
        return answer;
    }

    @Override
    public void showRightAnswerText(String answerText) {
        console.printf("%s%n%n", answerText);
    }
}