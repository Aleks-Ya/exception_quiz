package exceptionquiz.answer;

import exceptionquiz.Answer;
import org.junit.Test;

import java.io.EOFException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PackageAndClassNameAnswerTest {

    @Test
    public void testIsRight() throws Exception {
        Answer answer = new PackageAndClassNameAnswer(EOFException.class);
        assertTrue(answer.isRight("java.io.EOFException"));
        assertFalse(answer.isRight("java.io.IOException"));
        assertFalse(answer.isRight(""));
        assertFalse(answer.isRight(null));
    }
}