package exceptionquiz.plugin.exception;

import exceptionquiz.plugin.exception.ExcData;
import exceptionquiz.api.Question;
import exceptionquiz.plugin.exception.ParentClass;
import org.junit.Test;

import java.io.EOFException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParentClassTest {
    @Test
    public void test() {
        ExcData excData = new ExcData(EOFException.class, "-");
        Question q = new ParentClass(excData);
        assertEquals("What is parent of EOFException?", q.getQuestionText());
        assertEquals("java.io.IOException", q.getAnswerText());
        assertTrue(q.getRightAnswer().isRight("java.io.IOException"));
    }
}