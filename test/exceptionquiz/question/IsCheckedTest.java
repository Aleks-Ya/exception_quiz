package exceptionquiz.question;

import exceptionquiz.ExcData;
import exceptionquiz.Question;
import exceptionquiz.answer.NoAnswer;
import exceptionquiz.answer.YesAnswer;
import exceptionquiz.excdata.ExcDataImpl;
import org.junit.Test;

import java.io.EOFException;

import static org.junit.Assert.assertEquals;

public class IsCheckedTest {

    @Test
    public void unchecked() {
        ExcData excData = new ExcDataImpl(ArrayIndexOutOfBoundsException.class, "-");
        Question q = new IsChecked(excData);
        assertEquals("Is ArrayIndexOutOfBoundsException checked exception?", q.getQuestionText());
        assertEquals("ArrayIndexOutOfBoundsException is unchecked exception", q.getAnswerText());
        assertEquals(NoAnswer.getInstance(), q.getRightAnswer());
    }

    @Test
    public void checked() {
        ExcData excData = new ExcDataImpl(EOFException.class, "-");
        Question q = new IsChecked(excData);
        assertEquals("Is EOFException checked exception?", q.getQuestionText());
        assertEquals("EOFException is checked exception", q.getAnswerText());
        assertEquals(YesAnswer.getInstance(), q.getRightAnswer());
    }

    @Test
    public void throwable() {
        ExcData excData = new ExcDataImpl(Throwable.class, "-");
        Question q = new IsChecked(excData);
        assertEquals("Is Throwable checked exception?", q.getQuestionText());
        assertEquals("Throwable is checked exception", q.getAnswerText());
        assertEquals(YesAnswer.getInstance(), q.getRightAnswer());
    }

    @Test
    public void classCastException() {
        ExcData excData = new ExcDataImpl(ClassCastException.class, "-");
        Question q = new IsChecked(excData);
        assertEquals("Is ClassCastException checked exception?", q.getQuestionText());
        assertEquals("ClassCastException is unchecked exception", q.getAnswerText());
        assertEquals(NoAnswer.getInstance(), q.getRightAnswer());
    }

    @Test
    public void runtimeException() {
        ExcData excData = new ExcDataImpl(RuntimeException.class, "-");
        Question q = new IsChecked(excData);
        assertEquals("Is RuntimeException checked exception?", q.getQuestionText());
        assertEquals("RuntimeException is unchecked exception", q.getAnswerText());
        assertEquals(NoAnswer.getInstance(), q.getRightAnswer());
    }

    @Test
    public void errorsAreUnchecked() {
        ExcData excData = new ExcDataImpl(ExceptionInInitializerError.class, "-");
        Question q = new IsChecked(excData);
        assertEquals("Is ExceptionInInitializerError checked exception?", q.getQuestionText());
        assertEquals("ExceptionInInitializerError is unchecked exception", q.getAnswerText());
        assertEquals(NoAnswer.getInstance(), q.getRightAnswer());
    }
}