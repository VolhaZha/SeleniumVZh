package testNG;

import com.google.gson.JsonSyntaxException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestJsonParser {
    private Cart expectedCart;
    private Cart actualCart;
    JsonParser jsonParser;

    @BeforeMethod
    public void setParams() {
        jsonParser = new JsonParser();
    }

    @Test (priority = 1)
    public void testFileExists() {
        expectedCart = new Cart("TestCart");

        expectedCart.addRealItem(new RealItem());
        expectedCart.addVirtualItem(new VirtualItem());

        jsonParser.writeToFile(expectedCart);

        File file = new File("src\\main\\resources\\TestCart.json");
        Assert.assertTrue(file.exists(), "File does not exist");

    }

    @Test (enabled = false)
    public void testReadCartNameFromFile() throws IOException {
        expectedCart = new Cart("TestCart");

        File file = new File("src\\main\\resources\\TestCart.json");
        actualCart = jsonParser.readFromFile(file);

        Assert.assertEquals(actualCart.getCartName(),"TestCart",  "Cart Name can not be obtained");
    }

    @Test (priority = 2, expectedExceptions = NoSuchFileException.class)
    public void testFileDoesNotExist() {
        File file = new File("src\\main\\resources\\NoFile");
        expectedCart = new Cart("TestCart");
        jsonParser.readFromFile(file);
    }



    @Test (priority = 3)
    public void testOtherExceptions() throws IOException {
        //broken file
        File file = new File("src\\main\\resources\\broken.json");
        expectedCart = new Cart("broken");
        jsonParser.writeToFile(expectedCart);

        FileWriter writer = new FileWriter(file);
        writer.write("{invalidJson}");
        writer.close();

        Assert.assertThrows(JsonSyntaxException.class, () -> {
            jsonParser.readFromFile(file);
        });

        //empty file
        Assert.assertThrows(NullPointerException.class, () -> {
            Cart cart = jsonParser.readFromFile(new File("src\\main\\resources\\emptyFile.json"));
            Assert.assertNull(cart.getCartName(), "NullPointerException was expected");
        });

        //no Real Item
        Assert.assertThrows(NullPointerException.class, () -> {
            Cart cart = jsonParser.readFromFile(new File("src\\main\\resources\\noRealItem.json"));
            cart.showItems();
        });

        //no Virtual Item
        Assert.assertThrows(NullPointerException.class, () -> {
            Cart cart = jsonParser.readFromFile(new File("src\\main\\resources\\noVirtualItem.json"));
            cart.showItems();
        });
    }
    @AfterClass
    public void deleteTestFile () throws IOException {
        Files.delete(Paths.get("src/main/resources/TestCart.json"));
        Files.delete(Paths.get("src/main/resources/broken.json"));
    }
}
