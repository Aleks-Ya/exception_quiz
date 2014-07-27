package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.ExcData;
import exceptionquiz.Question;
import exceptionquiz.excdata.ExcDataImpl;
import org.junit.Test;

import java.io.EOFException;

import static org.junit.Assert.assertEquals;

public class ByDescriptionTest {
    @Test
    public void test() {
        ExcData excData = new ExcDataImpl(EOFException.class, "Signals that an end of file or end of stream has been reached " +
                "unexpectedly during input");
        Question q = new ByDescription(excData);
        assertEquals("Which exception (package and name) is used for \"Signals that an end of file or end of stream has been reached " +
                "unexpectedly during input\"?", q.getQuestionText());
        assertEquals("java.io.EOFException", q.getAnswerText());
        assertEquals(AnswerType.ENTER_TEXT, q.getAnswerType());
    }
}