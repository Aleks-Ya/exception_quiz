package exceptionquiz.question;

import exceptionquiz.ExcData;
import exceptionquiz.Question;
import exceptionquiz.excdata.ExcDataImpl;
import org.junit.Test;

import java.io.EOFException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParentClassTest {
    @Test
    public void test() {
        ExcData excData = new ExcDataImpl(EOFException.class, "-");
        Question q = new ParentClass(excData);
        assertEquals("What is parent of EOFException?", q.getQuestionText());
        assertEquals("java.io.IOException", q.getAnswerText());
        assertTrue(q.getRightAnswer().isRight("java.io.IOException"));
    }
}