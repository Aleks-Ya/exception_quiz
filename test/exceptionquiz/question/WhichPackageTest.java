package exceptionquiz.question;

import exceptionquiz.AnswerType;
import exceptionquiz.ExcData;
import exceptionquiz.Question;
import exceptionquiz.excdata.ExcDataImpl;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class WhichPackageTest {

    @Test
    public void unchecked() {
        ExcData excData = new ExcDataImpl(IOException.class, "-");
        Question q = new WhichPackage(excData);
        assertEquals("Which package is IOException located?", q.getQuestionText());
        assertEquals("java.io", q.getAnswerText());
        assertEquals(AnswerType.ENTER_TEXT, q.getAnswerType());
    }
}