package exceptionquiz.plugin.exception.answer;

import exceptionquiz.api.Answer;
import org.junit.Test;

import static org.junit.Assert.*;

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

}