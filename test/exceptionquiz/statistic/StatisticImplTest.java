package exceptionquiz.statistic;

import exceptionquiz.Statistic;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static com.googlecode.catchexception.CatchException.verifyException;
import static org.junit.Assert.assertEquals;

public class StatisticImplTest {
    private final Statistic st = new StatisticImpl();
    private static final int DURATION = 300;
    private Date startTime;
    private Date finishTime;

    @Before
    public void before() {
        DateTime start = new DateTime();
        startTime = start.toDate();
        finishTime = start.plusSeconds(DURATION).toDate();
    }

    @Test
    public void getDuration() throws Exception {
        verifyException(st, NullPointerException.class).getDuration();
        st.setStartTime(startTime);
        verifyException(st, NullPointerException.class).getDuration();
        st.setFinishTime(finishTime);
        assertEquals(DURATION, st.getDuration());
    }

    @Test
    public void getDurationPerQuestion() throws Exception {
        verifyException(st, NullPointerException.class).getDurationPerQuestion();
        st.setStartTime(startTime);
        verifyException(st, NullPointerException.class).getDurationPerQuestion();
        st.setFinishTime(finishTime);
        assertEquals(DURATION, st.getDurationPerQuestion());

        st.incRightQuestions();
        st.incMistakeQuestions();
        assertEquals(DURATION / 2, st.getDurationPerQuestion());
    }

    @Test
    public void getTimePerQuestion() throws Exception {
        verifyException(st, NullPointerException.class).getDurationPerQuestion();
        st.setStartTime(startTime);
        verifyException(st, NullPointerException.class).getDurationPerQuestion();
        st.setFinishTime(finishTime);
        assertEquals(DURATION, st.getDurationPerQuestion());
    }

    @Test
    public void getNextQuestionNumbers() {
        for (int i = 1; i < 10; i++) {
            assertEquals(i, st.getNextQuestionNumber());
            if (i % 2 == 0) {
                st.incRightQuestions();
            } else {
                st.incMistakeQuestions();
            }
        }
    }

    @Test
    public void getFinishedQuestions() throws Exception {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, st.getFinishedQuestions());
            if (i % 2 == 0) {
                st.incRightQuestions();
            } else {
                st.incMistakeQuestions();
            }
        }
    }

    @Test
    public void getPercent() throws Exception {
        st.incRightQuestions();
        st.incRightQuestions();
        st.incRightQuestions();
        st.incMistakeQuestions();

        assertEquals(75, st.getRightPercent());
        assertEquals(25, st.getMistakePercent());
    }
}