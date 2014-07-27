package exceptionquiz.answer;

import exceptionquiz.Answer;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NoAnswerTest {

    @Test
    public void isRight() {
        Answer answer = NoAnswer.getInstance();

        assertTrue(answer.isRight(" No "));
        assertTrue(answer.isRight("N"));
        assertTrue(answer.isRight(" n "));
        assertTrue(answer.isRight(" нет"));
        assertTrue(answer.isRight(" н"));

        assertFalse(answer.isRight(null));
        assertFalse(answer.isRight(""));
        assertFalse(answer.isRight("   "));
        assertFalse(answer.isRight("yes"));
    }

}