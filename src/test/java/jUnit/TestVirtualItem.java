package jUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import java.io.IOException;

public class TestVirtualItem {
    VirtualItem virtualItemItem = new VirtualItem();

    @Test
    public void testGetSize() throws IOException {
        virtualItemItem.setSizeOnDisk(12);
        Assertions.assertEquals(12, virtualItemItem.getSizeOnDisk(),0.001, "Expected value does not match actual value");
    }
}
