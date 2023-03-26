package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.VirtualItem;

import java.io.IOException;

public class TestVirtualItem {
    VirtualItem virtualItemItem = new VirtualItem();

    @Test
    public void testGetSize() throws IOException {
        virtualItemItem.setSizeOnDisk(12);
        Assert.assertEquals(virtualItemItem.getSizeOnDisk(),12,0.001, "Expected value does not match actual value");
    }
}