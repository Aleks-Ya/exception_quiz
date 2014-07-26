package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.Question;
import org.junit.Test;

import java.io.EOFException;
import java.io.IOException;

import static org.junit.Assert.*;

public class IsCheckedTest {

    @Test
    public void unchecked() {
        Question q = new IsChecked(ArrayIndexOutOfBoundsException.class);
        assertEquals("Is ArrayIndexOutOfBoundsException checked exception?", q.getQuestionText());
        assertEquals("ArrayIndexOutOfBoundsException is UN checked exception", q.getAnswerText());
        assertEquals(AnswerType.YES_NO, q.getAnswerType());
    }

    @Test
    public void checked() {
        Question q = new IsChecked(EOFException.class);
        assertEquals("Is EOFException checked exception?", q.getQuestionText());
        assertEquals("EOFException is checked exception", q.getAnswerText());
        assertEquals(AnswerType.YES_NO, q.getAnswerType());
    }
}