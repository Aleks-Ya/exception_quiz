package exceptionquiz.application.answer;

import exceptionquiz.application.answer.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AbstractAnswerTest {

    @Test
    public void equals() {
        //YesAnswer и NoAnswer
        assertEquals(YesAnswer.getInstance(), YesAnswer.getInstance());
        assertNotEquals(YesAnswer.getInstance(), NoAnswer.getInstance());

        //PackageNameAnswer
        assertEquals(new PackageNameAnswer(IOException.class), new PackageNameAnswer(IOException.class));
        assertNotEquals(new PackageNameAnswer(IOException.class), new PackageNameAnswer(Exception.class));
        assertNotEquals(new PackageNameAnswer(Exception.class), YesAnswer.getInstance());

        //PackageAndClassNameAnswer
        assertEquals(new PackageAndClassNameAnswer(IOException.class), new PackageAndClassNameAnswer(IOException.class));
        assertNotEquals(new PackageAndClassNameAnswer(IOException.class), new PackageAndClassNameAnswer(Exception.class));
        assertNotEquals(new PackageAndClassNameAnswer(Exception.class), YesAnswer.getInstance());

        //QuitAnswer
        assertEquals(new QuitAnswer(), new QuitAnswer());
        assertNotEquals(new QuitAnswer(), new PackageAndClassNameAnswer(Exception.class));
        assertNotEquals(new QuitAnswer(), YesAnswer.getInstance());
    }
}