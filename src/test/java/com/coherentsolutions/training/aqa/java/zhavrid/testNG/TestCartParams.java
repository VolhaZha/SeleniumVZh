package com.coherentsolutions.training.aqa.java.zhavrid.testNG;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;

public class TestCartParams {
    private Cart cart;
    private RealItem car;
    @BeforeMethod
    @Parameters({"cartName", "carName", "carPrice", "carWeight"})
    public void setParams(String cartName, String carName, double carPrice, double carWeight) {
        cart = new Cart(cartName);
        car = new RealItem();
        car.setName(carName);
        car.setPrice(carPrice);
        car.setWeight(carWeight);
    }

    @Test (priority = 1)
    public void testGetCartName() {
        Assert.assertEquals(cart.getCartName(),"TestCart", "Cart Name can not be obtained");
    }

    @Test (priority = 2)
    public void testAddRealItem() {
        cart.addRealItem(car);
        Assert.assertEquals(cart.getTotalPrice(),12,  0.001, "Expected value does not match actual value");
    }

    @Test (priority = 3)
    public void testDeleteRealItem() {
        cart.addRealItem(car);
        cart.deleteRealItem(car);
        Assert.assertEquals(cart.getTotalPrice(),0,  0.001, "Expected value does not match actual value");
    }
}
