package exceptionquiz.excset;

import exceptionquiz.ExcSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Jcp2ExcSetTest {

    @Test
    public void getExcs() throws Exception {
        ExcSet set = new Jcp1ExcSet();
        assertEquals(17, set.getExcs().size());
    }
}