package jUnit;

import org.junit.Test;
import shop.RealItem;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestRealItem {
    RealItem realItem = new RealItem();

    @Test
    public void testGetWeight() throws IOException {
        realItem.setWeight(12);
        assertEquals("Expected value does not match actual value", 12, realItem.getWeight(),0.001);
    }
}
