package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.Question;
import org.junit.Test;

import java.io.EOFException;

import static org.junit.Assert.assertEquals;

public class ParentClassTest {
    @Test
    public void test() {
        Question q = new ParentClass(EOFException.class);
        assertEquals("What is parent class of EOFException?", q.getQuestionText());
        assertEquals("java.io.IOException", q.getAnswerText());
        assertEquals(AnswerType.ENTER_TEXT, q.getAnswerType());
    }
}