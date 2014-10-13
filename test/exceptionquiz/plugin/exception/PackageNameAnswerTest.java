package exceptionquiz.plugin.exception;

import exceptionquiz.api.Answer;
import exceptionquiz.api.answer.YesAnswer;
import exceptionquiz.plugin.exception.PackageNameAnswer;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class PackageNameAnswerTest {

    @Test
    public void isRight() throws Exception {
        Answer answer = new PackageNameAnswer(IOException.class);
        assertTrue(answer.isRight(" java.io "));
        assertFalse(answer.isRight("java.net"));
        assertFalse(answer.isRight("java.IO"));
        assertFalse(answer.isRight(""));
        assertFalse(answer.isRight(null));
    }

    @Test
    public void isEquals() {
        assertEquals(new PackageNameAnswer(IOException.class), new PackageNameAnswer(IOException.class));
        assertNotEquals(new PackageNameAnswer(IOException.class), new PackageNameAnswer(Exception.class));
        assertNotEquals(new PackageNameAnswer(Exception.class), YesAnswer.getInstance());
    }
}