package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.RealItem;

import java.io.IOException;

public class TestRealItem {
    RealItem realItem = new RealItem();

    @Test
    public void testGetWeight() throws IOException {
        realItem.setWeight(12);
        Assert.assertEquals(realItem.getWeight(),12,0.001, "Expected value does not match actual value");
    }
}
