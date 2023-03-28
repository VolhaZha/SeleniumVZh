package testNG;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;

public class TestCart {
   // private Cart cart;
    private static final Cart CART = new Cart("TestCart");

    private RealItem car;
    @BeforeMethod
    public void setParams() {
     //   cart = new Cart("TestCart");
        car = new RealItem();
        car.setName("Audi");
        car.setPrice(10);
        car.setWeight(50);
    }

    @Test (priority = 1)
    public void testGetCartName() {
        Assert.assertEquals(CART.getCartName(),"TestCart", "Cart Name can not be obtained");
    }

    @Test (priority = 2)
    public void testAddRealItem() {
        CART.addRealItem(car);
        Assert.assertEquals(CART.getTotalPrice(),12,  0.001, "Expected value does not match actual value");
    }

    @Test (priority = 3)
    public void testDeleteRealItem() {
        CART.deleteRealItem(car);
        Assert.assertEquals(CART.getTotalPrice(),0,  0.001, "Expected value does not match actual value");
    }
}
