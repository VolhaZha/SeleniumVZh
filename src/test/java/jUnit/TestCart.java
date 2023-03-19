package jUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCart {
        Cart cart = new Cart("TestCart");
        RealItem car = new RealItem();

    @Test
    public void testGetCartName() {
        Assert.assertEquals("Cart Name can not be obtained","TestCart", cart.getCartName());
    }

    @Test
    public void testAddRealItem() {
        car.setName("Audi");
        car.setPrice(10);
        car.setWeight(50);
        cart.addRealItem(car);
        assertEquals(12, cart.getTotalPrice(), 0.001, "Expected value does not match actual value");
    }

    @Test
    public void testDeleteRealItem() {
        car.setName("Audi");
        car.setPrice(10);
        car.setWeight(50);
        cart.deleteRealItem(car);
        assertEquals(0, cart.getTotalPrice(), 0.001, "Expected value does not match actual value");
    }
}
