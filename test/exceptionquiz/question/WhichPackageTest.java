package exceptionquiz.question;

import exceptionquiz.ExcData;
import exceptionquiz.Question;
import exceptionquiz.excdata.ExcDataImpl;
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