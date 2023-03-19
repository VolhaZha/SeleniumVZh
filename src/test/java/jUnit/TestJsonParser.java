package jUnit;

import com.google.gson.JsonSyntaxException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testFileExists() {
        expectedCart = new Cart("TestCart");

        expectedCart.addRealItem(new RealItem());
        expectedCart.addVirtualItem(new VirtualItem());

        JsonParser jsonParser = new JsonParser();
        jsonParser.writeToFile(expectedCart);

        File file = new File("src\\main\\resources\\TestCart.json");
        assertTrue(file.exists(), "File does not exist");

    }

    @Ignore
    public void testReadCartNameFromFile() throws IOException {
        expectedCart = new Cart("TestCart");
        JsonParser jsonParser = new JsonParser();

        File file = new File("src\\main\\resources\\TestCart.json");
        actualCart = jsonParser.readFromFile(file);

        Assert.assertEquals("Cart Name can not be obtained", "TestCart", actualCart.getCartName());
    }

    @Test
    public void testFileDoesNotExist() {
        File file = new File("src\\main\\resources\\NoFile");
        expectedCart = new Cart("TestCart");
        NoSuchFileException exception = assertThrows(NoSuchFileException.class, () -> {
            JsonParser jsonParser = new JsonParser();
            jsonParser.writeToFile(expectedCart);
            jsonParser.readFromFile(file);
        });
        Assert.assertEquals("File does not exist", "File src\\main\\resources\\NoFile.json not found!", exception.getMessage());
    }

    @Test
    public void testOtherExceptions() throws IOException {
        //broken file
        File file = new File("src\\main\\resources\\broken.json");
        expectedCart = new Cart("broken");
        JsonParser parser = new JsonParser();
        parser.writeToFile(expectedCart);

        FileWriter writer = new FileWriter(file);
        writer.write("{invalidJson}");
        writer.close();

        Assertions.assertThrows(JsonSyntaxException.class, () -> {
            parser.readFromFile(file);
        });

        //empty file
        File emptyFile = new File("src\\main\\resources\\empty.json");
        expectedCart = null;
        JsonParser parser2 = new JsonParser();

        NoSuchFileException exception = assertThrows(NoSuchFileException.class, () -> {
            parser2.readFromFile(emptyFile);
        });

        assertEquals(String.format("File %s.json not found!", emptyFile), exception.getMessage(), "File is empty");

        //no Real Item
        Assertions.assertThrows(NullPointerException.class, () -> {
            JsonParser parser3 = new JsonParser();
            Cart cart = parser3.readFromFile(new File("src/main/resources/noRealItem.json"));
            cart.showItems();
        });

        //no Virtual Item
        Assertions.assertThrows(NullPointerException.class, () -> {
            JsonParser parser4 = new JsonParser();
            Cart cart = parser4.readFromFile(new File("src/main/resources/noVirtualItem.json"));
            cart.showItems();
        });
    }
        @After
        public void deleteTestFile () throws IOException {
                Files.delete(Paths.get("src\\main\\resources\\" + expectedCart.getCartName() + ".json"));
        }
}
