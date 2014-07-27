package exceptionquiz.excset;

import exceptionquiz.ExcSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Jcp1ExcSetTest {

    @Test
    public void getExcs() throws Exception {
        ExcSet set = Jcp1ExcSet.getInstance();
        assertEquals(17, set.getExcs().size());
    }
}