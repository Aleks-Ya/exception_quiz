package exceptionquiz.application;

import exceptionquiz.api.answer.NoAnswer;
import exceptionquiz.api.answer.YesAnswer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class QuitAnswerTest {

    @Test
    public void isEquals() {
        assertEquals(new QuitAnswer(), new QuitAnswer());
        assertNotEquals(new QuitAnswer(), NoAnswer.getInstance());
        assertNotEquals(new QuitAnswer(), YesAnswer.getInstance());
    }
}