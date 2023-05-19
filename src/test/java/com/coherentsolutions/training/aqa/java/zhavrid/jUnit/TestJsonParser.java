package com.coherentsolutions.training.aqa.java.zhavrid.jUnit;

import com.google.gson.JsonSyntaxException;
import org.junit.jupiter.api.*;
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

import static org.junit.jupiter.api.Assertions.*;

public class TestJsonParser {
    private Cart expectedCart;
    private Cart actualCart;
    JsonParser jsonParser;

    @BeforeEach
    public void setParams() {
        jsonParser = new JsonParser();
    }

    @Test
    public void testFileExists() {
        expectedCart = new Cart("TestCart");

        expectedCart.addRealItem(new RealItem());
        expectedCart.addVirtualItem(new VirtualItem());

        jsonParser.writeToFile(expectedCart);

        File file = new File("src\\main\\resources\\TestCart.json");
        assertTrue(file.exists(), "File does not exist");

    }

    @Disabled
    public void testReadCartNameFromFile() throws IOException {
        expectedCart = new Cart("TestCart");

        File file = new File("src\\main\\resources\\TestCart.json");
        actualCart = jsonParser.readFromFile(file);

        Assertions.assertEquals("TestCart", actualCart.getCartName(), "Cart Name can not be obtained");
    }

    @Test
    public void testFileDoesNotExist() {
        File file = new File("src\\main\\resources\\NoFile");
        expectedCart = new Cart("TestCart");

        NoSuchFileException exception = assertThrows(NoSuchFileException.class, () -> {
            jsonParser.writeToFile(expectedCart);
            jsonParser.readFromFile(file);
        });
        Assertions.assertEquals("File src\\main\\resources\\NoFile.json not found!", exception.getMessage(), "NoSuchFileException was expected");
    }

    @Test
    public void testOtherExceptions() throws IOException {
        //broken file
        File file = new File("src\\main\\resources\\broken.json");
        expectedCart = new Cart("broken");
        jsonParser.writeToFile(expectedCart);

        FileWriter writer = new FileWriter(file);
        writer.write("{invalidJson}");
        writer.close();

        Assertions.assertThrows(JsonSyntaxException.class, () -> {
            jsonParser.readFromFile(file);
        });

        //empty file
        Assertions.assertThrows(NullPointerException.class, () -> {
            Cart cart = jsonParser.readFromFile(new File("src\\main\\resources\\emptyFile.json"));
            Assertions.assertNull(cart.getCartName(), "NullPointerException was expected");
        });

        //no Real Item
        Assertions.assertThrows(NullPointerException.class, () -> {
            Cart cart = jsonParser.readFromFile(new File("src\\main\\resources\\noRealItem.json"));
            cart.showItems();
        });

        //no Virtual Item
        Assertions.assertThrows(NullPointerException.class, () -> {
            Cart cart = jsonParser.readFromFile(new File("src\\main\\resources\\noVirtualItem.json"));
            cart.showItems();
        });
    }
        @AfterEach
        public void deleteTestFile () throws IOException {
            Files.delete(Paths.get("src/main/resources/" + expectedCart.getCartName() + ".json"));
        }
}
