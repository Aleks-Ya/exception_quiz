package exceptionquiz.inquirer;

import exceptionquiz.Formatter;
import exceptionquiz.Inquirer;
import exceptionquiz.Question;
import exceptionquiz.Statistic;

import java.io.Console;

/**
 * Опрос пользователя через консоль.
 */
public class ConsoleInquirer implements Inquirer {
    private final Console console;
    private Statistic statistic;
    private Formatter<Statistic> formatter;

    public ConsoleInquirer() {
        console = System.console();
        if (console == null) {
            throw new IllegalStateException("Console is not available. Run from console.");
        }
    }

    public ConsoleInquirer(Statistic statistic, Formatter<Statistic> formatter) {
        this();
        this.statistic = statistic;
        this.formatter = formatter;
    }

    @Override
    public void showQuestionText(Question question) {
        if (statistic != null) {
            console.printf("%d %s%n", statistic.getNextQuestionNumber(), question.getQuestionText());
        } else {
            console.printf("%s%n", question.getQuestionText());
        }
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

    @Override
    public void showStatistic(Statistic statistic) {
        console.printf("%s", formatter.format(statistic));
    }

    @Override
    public void showInfoMessage(String message) {
        console.printf("%s%n", message);
    }
}