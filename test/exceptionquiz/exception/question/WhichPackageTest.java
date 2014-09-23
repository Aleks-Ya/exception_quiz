package exceptionquiz.exception.question;

import exceptionquiz.exception.ExcData;
import exceptionquiz.api.Question;
import exceptionquiz.exception.excdata.ExcDataImpl;
import exceptionquiz.exception.question.WhichPackage;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WhichPackageTest {

    @Test
    public void unchecked() {
        ExcData excData = new ExcDataImpl(IOException.class, "-");
        Question q = new WhichPackage(excData);
        assertEquals("Which package is IOException located?", q.getQuestionText());
        assertEquals("java.io", q.getAnswerText());
        assertTrue(q.getRightAnswer().isRight("java.io"));
    }
}