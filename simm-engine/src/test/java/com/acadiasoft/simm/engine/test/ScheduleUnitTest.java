package com.acadiasoft.simm.engine.test;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ScheduleUnitTest extends AbstractAcadiaUnitTestV2_0 {

    @Test
    public void testTest() {

        BigDecimal val1 = SN1.getNotionalUSD();
        BigDecimal val2 = SPV2.getPVUSD();

        BigDecimal val3 = val1.add(val2);

        Assert.assertEquals(new BigDecimal("990000"), val3);
    }

}
