package jUnit;

import org.junit.Test;
import shop.VirtualItem;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestVirtualItem {
    VirtualItem virtualItemItem = new VirtualItem();

    @Test
    public void testGetSize() throws IOException {
        virtualItemItem.setSizeOnDisk(12);
        assertEquals("Expected value does not match actual value", 12, virtualItemItem.getSizeOnDisk(),0.001);
    }
}
