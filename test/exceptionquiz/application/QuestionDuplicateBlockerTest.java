package exceptionquiz.application;

import exceptionquiz.api.Question;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class QuestionDuplicateBlockerTest {
    private final DuplicateBlocker<Question> blocker = new QuestionDuplicateBlocker();
    private int limit;

    @Before
    public void setUp() throws Exception {
        Field limitField = QuestionDuplicateBlocker.class.getDeclaredField("limit");
        limitField.setAccessible(true);
        limit = limitField.getInt(blocker);
    }

    @Test
    public void block() {
        Question q = mock(Question.class);

        // 1ый раз - не дубликат, 2ой раз и больше - дубликат
        assertFalse(blocker.isDuplicate(q));
        for (int i = 0; i < limit; i++) {
            assertTrue(blocker.isDuplicate(q));
        }

        Question q2 = mock(Question.class);
        assertFalse(blocker.isDuplicate(q2));
        assertTrue(blocker.isDuplicate(q2));
        assertTrue(blocker.isDuplicate(q));
    }

    /**
     * После N вопросов блокировка снимается.
     */
    @Test
    public void size() throws IllegalAccessException {
        Question q = mock(Question.class);

        assertFalse(blocker.isDuplicate(q));
        assertTrue(blocker.isDuplicate(q));
        for (int i = 0; i < limit; i++) {
            assertFalse(blocker.isDuplicate(mock(Question.class)));
        }
        assertFalse(blocker.isDuplicate(q));
        assertTrue(blocker.isDuplicate(q));
    }
}