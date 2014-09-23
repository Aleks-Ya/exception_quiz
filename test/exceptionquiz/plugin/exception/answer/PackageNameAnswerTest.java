package exceptionquiz.plugin.exception.answer;

import exceptionquiz.api.Answer;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
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
}