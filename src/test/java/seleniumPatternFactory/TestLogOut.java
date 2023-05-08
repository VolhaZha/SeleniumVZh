package seleniumPatternFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogOut {
    WebDriver driver;
    Factory factory;

    @BeforeMethod
    public void launchBrowser() throws InterruptedException {
        factory = new Factory();
        driver = WebDriverSingleton.initialize();
        WebDriverSingleton.driver = driver;
        factory = PageFactory.initElements(driver, Factory.class);
        TestLogIn logIn = new TestLogIn();
        logIn.launchBrowser();
        logIn.testLogIn();
    }

    @Test(priority = 1)
    public void testLogOut() throws InterruptedException {
        driver.get(Params1.URLLOGOUT);

        factory.clickAvatar();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(Params1.FRAME));

        factory.clickSignOutButton();
    }

    @AfterMethod
    public void close() {
        WebDriverSingleton.close();
    }
}
