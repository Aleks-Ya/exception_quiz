package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.Question;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class WhichPackageTest {

    @Test
    public void unchecked() {
        Question q = new WhichPackage(IOException.class);
        assertEquals("Which package is IOException located?", q.getQuestionText());
        assertEquals("java.io", q.getAnswerText());
        assertEquals(AnswerType.ENTER_TEXT, q.getAnswerType());
    }
}