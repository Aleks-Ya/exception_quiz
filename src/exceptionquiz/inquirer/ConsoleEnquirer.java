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
        console.printf("%nSTATISTIC:%n");
        console.printf("Duration (sec): %d%n", statistic.getDuration());
        console.printf("Duration per question (sec): %d%n", statistic.getDurationPerQuestion());
        console.printf("Right question count: %d (%d%%)%n", statistic.getRightAnswers(), statistic.getRightPercent());
        console.printf("Mistake question count: %d (%d%%)%n", statistic.getMistakeAnswers(), statistic.getMistakePercent());
        console.printf("Total question count: %d%n%n", statistic.getFinishedQuestions());
    }

    @Override
    public void showInfoMessage(String message) {
        console.printf("%s%n", message);
    }
}