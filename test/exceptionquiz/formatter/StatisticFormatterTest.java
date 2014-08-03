package exceptionquiz.formatter;

import exceptionquiz.Formatter;
import exceptionquiz.Statistic;
import exceptionquiz.statistic.StatisticImpl;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class StatisticFormatterTest {
    private static final int DURATION = 80;
    private Date startTime;
    private Date finishTime;

    @Before
    public void before() {
        DateTime start = new DateTime();
        startTime = start.toDate();
        finishTime = start.plusSeconds(DURATION).toDate();
    }

    @Test
    public void testFormat() throws Exception {
        Statistic statistic = new StatisticImpl();
        statistic.setStartTime(startTime);
        statistic.setFinishTime(finishTime);
        statistic.incRightQuestions();
        statistic.incRightQuestions();
        statistic.incRightQuestions();
        statistic.incMistakeQuestions();

        Formatter<Statistic> formatter = new StatisticFormatter();
        String actual = formatter.format(statistic);
        String expected = "\nSTATISTIC:\n" +
                "Duration (min:sec):          1:20\n" +
                "Duration per question (sec): 20\n" +
                "Right question count:        3 (75%)\n" +
                "Mistake question count:      1 (25%)\n" +
                "Total question count:        4\n\n";

        assertEquals(expected, actual);
    }
}