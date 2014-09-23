package exceptionquiz.application.formatter;

import exceptionquiz.application.Formatter;
import exceptionquiz.application.Statistic;

/**
 * Представляет Статистику в виде строки для вывода на консоль.
 */
public class StatisticFormatter implements Formatter<Statistic> {
    private static final int SECONDS_IN_MINUTE = 60;

    @Override
    public String format(Statistic statistic) {
        int duration = statistic.getDuration();
        int durationMin = duration / SECONDS_IN_MINUTE;
        int durationSec = duration % SECONDS_IN_MINUTE;
        return "\nSTATISTIC:\n"
                + String.format("Duration (min:sec):          %d:%02d%n", durationMin, durationSec)
                + String.format("Duration per question (sec): %d%n", statistic.getDurationPerQuestion())
                + String.format("Right question count:        %d (%d%%)%n", statistic.getRightAnswers(), statistic.getRightPercent())
                + String.format("Mistake question count:      %d (%d%%)%n", statistic.getMistakeAnswers(), statistic.getMistakePercent())
                + String.format("Total question count:        %d%n%n", statistic.getFinishedQuestions());
    }
}