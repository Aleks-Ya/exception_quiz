package exceptionquiz.plugin.exception.question;

import exceptionquiz.api.Answer;
import exceptionquiz.api.answer.YesAnswer;
import org.junit.Test;

import java.io.EOFException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class PackageAndClassNameAnswerTest {

    @Test
    public void testIsRight() throws Exception {
        Answer answer = new PackageAndClassNameAnswer(EOFException.class);
        assertTrue(answer.isRight("java.io.EOFException"));
        assertFalse(answer.isRight("java.io.EofException"));
        assertFalse(answer.isRight("java.io.IOException"));
        assertFalse(answer.isRight(""));
        assertFalse(answer.isRight(null));
    }

    @Test
    public void isEquals() {
        assertEquals(new PackageAndClassNameAnswer(IOException.class), new PackageAndClassNameAnswer(IOException.class));
        assertNotEquals(new PackageAndClassNameAnswer(IOException.class), new PackageAndClassNameAnswer(Exception.class));
        assertNotEquals(new PackageAndClassNameAnswer(Exception.class), YesAnswer.getInstance());
    }
}