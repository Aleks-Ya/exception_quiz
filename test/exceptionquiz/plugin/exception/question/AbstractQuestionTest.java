package exceptionquiz.plugin.exception.question;

import exceptionquiz.api.Question;
import exceptionquiz.plugin.exception.ExcData;
import exceptionquiz.plugin.exception.excdata.ExcDataImpl;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AbstractQuestionTest {

    @Test
    public void equalsByDescription() {
        ExcData data1 = new ExcDataImpl(IOException.class, "description1");
        ExcData data2 = new ExcDataImpl(IOException.class, "description2");
        Question q1 = new ByDescription(data1);
        Question q2 = new ByDescription(data2);
        Question q3 = new ByDescription(data1);
        assertEquals(q1, q3);
        assertNotEquals(q1, q2);
        assertNotEquals(q2, q3);
    }

    @Test
    public void equalsIsChecked() {
        ExcData data1 = new ExcDataImpl(IOException.class, "description");
        ExcData data2 = new ExcDataImpl(IllegalArgumentException.class, "description");
        Question q1 = new IsChecked(data1);
        Question q2 = new IsChecked(data2);
        Question q3 = new IsChecked(data1);
        assertEquals(q1, q3);
        assertNotEquals(q1, q2);
        assertNotEquals(q2, q3);
    }

    @Test
    public void equalsParentClass() {
        ExcData data1 = new ExcDataImpl(IOException.class, "description");
        ExcData data2 = new ExcDataImpl(IllegalArgumentException.class, "description");
        Question q1 = new ParentClass(data1);
        Question q2 = new ParentClass(data2);
        Question q3 = new ParentClass(data1);
        assertEquals(q1, q3);
        assertNotEquals(q1, q2);
        assertNotEquals(q2, q3);
    }

    @Test
    public void equalsWhichPackage() {
        ExcData data1 = new ExcDataImpl(IOException.class, "description");
        ExcData data2 = new ExcDataImpl(IllegalArgumentException.class, "description");
        Question q1 = new WhichPackage(data1);
        Question q2 = new WhichPackage(data2);
        Question q3 = new WhichPackage(data1);
        assertEquals(q1, q3);
        assertNotEquals(q1, q2);
        assertNotEquals(q2, q3);
    }
}