package exceptionquiz.application.formatter;

import exceptionquiz.application.Formatter;
import exceptionquiz.application.Statistic;
import exceptionquiz.application.statistic.StatisticImpl;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class StatisticFormatterTest {
    private final Formatter<Statistic> formatter = new StatisticFormatter();

    @Test
    public void testFormat() {
        String expected = "\nSTATISTIC:\n" +
                "Duration (min:sec):          1:20\n" +
                "Duration per question (sec): 20\n" +
                "Right question count:        3 (75%)\n" +
                "Mistake question count:      1 (25%)\n" +
                "Total question count:        4\n\n";

        String actual = formatter.format(generateStatistic(80, 3, 1));

        assertEquals(expected, actual);
    }

    /**
     * Если у "Duration (min:sec)" количество секунд <10, то должен быть ведущий 0.
     */
    @Test
    public void durationSecondLess10() {
        String expected = "\nSTATISTIC:\n" +
                "Duration (min:sec):          1:05\n" +
                "Duration per question (sec): 8\n" +
                "Right question count:        8 (100%)\n" +
                "Mistake question count:      0 (0%)\n" +
                "Total question count:        8\n\n";

        String actual = formatter.format(generateStatistic(65, 8, 0));

        assertEquals(expected, actual);
    }

    private static Statistic generateStatistic(int duration, int rightCount, int mistakeCount) {
        DateTime start = new DateTime();
        Date startTime = start.toDate();
        Date finishTime = start.plusSeconds(duration).toDate();

        Statistic statistic = new StatisticImpl();
        statistic.setStartTime(startTime);
        statistic.setFinishTime(finishTime);

        for (int i = 0; i < rightCount; i++) {
            statistic.incRightQuestions();
        }
        for (int i = 0; i < mistakeCount; i++) {
            statistic.incMistakeQuestions();
        }

        return statistic;
    }
}