package exceptionquiz.plugin.exception.question;

import exceptionquiz.api.Answer;
import exceptionquiz.api.answer.NoAnswer;
import exceptionquiz.api.answer.YesAnswer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class YesAnswerTest {

    @Test
    public void isRight() {
        Answer answer = YesAnswer.getInstance();

        assertTrue(answer.isRight("Yes"));
        assertTrue(answer.isRight("Y"));
        assertTrue(answer.isRight(" y "));
        assertTrue(answer.isRight(" да"));
        assertTrue(answer.isRight(" д"));

        assertFalse(answer.isRight(null));
        assertFalse(answer.isRight(""));
        assertFalse(answer.isRight("   "));
        assertFalse(answer.isRight("no"));
    }

    @Test
    public void isEquals() {
        assertEquals(YesAnswer.getInstance(), YesAnswer.getInstance());
        assertNotEquals(YesAnswer.getInstance(), NoAnswer.getInstance());
    }
}