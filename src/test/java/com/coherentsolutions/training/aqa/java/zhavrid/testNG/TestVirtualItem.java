package com.coherentsolutions.training.aqa.java.zhavrid.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.RealItem;
import shop.VirtualItem;

import java.io.IOException;

public class TestVirtualItem {
    private static final VirtualItem VIRTUAL_ITEM = new VirtualItem();

    @Test
    public void testGetSize() throws IOException {
        VIRTUAL_ITEM.setSizeOnDisk(12);
        Assert.assertEquals(VIRTUAL_ITEM.getSizeOnDisk(),12,0.001, "Expected value does not match actual value");
    }
}