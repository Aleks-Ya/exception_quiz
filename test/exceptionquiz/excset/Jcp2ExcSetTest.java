package exceptionquiz.excset;

import exceptionquiz.ExcSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Jcp2ExcSetTest {

    @Test
    public void getExcs() throws Exception {
        ExcSet set = Jcp2ExcSet.getInstance();
        assertEquals(18, set.getExcs().size());
    }
}