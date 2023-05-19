package com.coherentsolutions.training.aqa.java.zhavrid.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.RealItem;

import java.io.IOException;

public class TestRealItem {
    private static final RealItem REAL_ITEM = new RealItem();

    @Test
    public void testGetWeight() throws IOException {
        REAL_ITEM.setWeight(12);
        Assert.assertEquals(REAL_ITEM.getWeight(),12,0.001, "Expected value does not match actual value");
    }
}
