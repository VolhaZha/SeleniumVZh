package com.coherentsolutions.training.aqa.java.zhavrid.jUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCart {
    private Cart cart;
    private RealItem car;
    @BeforeEach
    public void setParams() {
        cart = new Cart("TestCart");
        car = new RealItem();
        car.setName("Audi");
        car.setPrice(10);
        car.setWeight(50);
    }

    @Test
    public void testGetCartName() {
        Assertions.assertEquals("TestCart", cart.getCartName(), "Cart Name can not be obtained");
    }

    @Test
    public void testAddRealItem() {
        cart.addRealItem(car);
        assertEquals(12, cart.getTotalPrice(), 0.001, "Expected value does not match actual value");
    }

    @Test
    public void testDeleteRealItem() {
        cart.deleteRealItem(car);
        assertEquals(0, cart.getTotalPrice(), 0.001, "Expected value does not match actual value");
    }
}
