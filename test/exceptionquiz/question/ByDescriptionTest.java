package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.Question;
import org.junit.Test;

import java.io.EOFException;

import static org.junit.Assert.assertEquals;

public class ByDescriptionTest {
    @Test
    public void test() {
        Question q = new ByDescription("Signals that an end of file or end of stream has been reached " +
                "unexpectedly during input", EOFException.class);
        assertEquals("Which exception is used for \"Signals that an end of file or end of stream has been reached " +
                "unexpectedly during input\"?", q.getQuestionText());
        assertEquals("java.io.EOFException", q.getAnswerText());
        assertEquals(AnswerType.ENTER_TEXT, q.getAnswerType());
    }
}