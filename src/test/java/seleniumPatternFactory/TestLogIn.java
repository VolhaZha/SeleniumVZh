package seleniumPatternFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogIn {
    WebDriver driver;
    Factory factory;

    @BeforeMethod
    public void launchBrowser() {
        factory = new Factory();
        driver = WebDriverSingleton.initialize();
        WebDriverSingleton.driver = driver;
        factory = PageFactory.initElements(driver, Factory.class);
    }

    @Test(priority = 1)
    public void testLogIn() throws InterruptedException {
        driver.get(Params1.URLLOGIN);

        factory.inputUsername("ooozoz");
        factory.clickLogInButton1();

        factory.inputPassword("1234567Oz!!!");
        factory.clickLogInButton2();

        Thread.sleep(1000);

        factory.clickConfirm();

        Thread.sleep(20000);

        String actualTitle = driver.getTitle();
        Assert.assertEquals( actualTitle.contains("ID"), true);
    }

    @AfterMethod
    public void close() {
        WebDriverSingleton.close();
    }
}
