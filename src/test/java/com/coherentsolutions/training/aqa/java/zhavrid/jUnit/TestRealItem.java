package com.coherentsolutions.training.aqa.java.zhavrid.jUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.RealItem;

import java.io.IOException;

public class TestRealItem {
    RealItem realItem = new RealItem();

    @Test
    public void testGetWeight() throws IOException {
        realItem.setWeight(12);
        Assertions.assertEquals(12, realItem.getWeight(),0.001, "Expected value does not match actual value");
    }
}
