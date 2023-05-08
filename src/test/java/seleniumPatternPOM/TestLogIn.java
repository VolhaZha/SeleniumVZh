package seleniumPatternPOM;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogIn {
    @BeforeMethod
    public void launchBrowser() {
        WebDriverSingleton.initialize();
    }

    @Test(priority = 1)
    public void testLogIn() throws InterruptedException {
        WebDriverSingleton.driver.get(Params2.URL_LOGIN);

        WebElement userName= WebDriverSingleton.driver.findElement(Params2.FIELD_INPUT_NAME);
        WebElement logInButton1= WebDriverSingleton.driver.findElement(Params2.BUTTON_LOGIN_1);
        userName.sendKeys("ooozoz");
        logInButton1.click();

        WebElement password= WebDriverSingleton.driver.findElement(Params2.FIELD_INPUT_PASSWORD);
        password.sendKeys("1234567Oz!!!");
        WebElement logInButton2= WebDriverSingleton.driver.findElement(Params2.BUTTON_LOGIN_2);
        logInButton2.click();

        Thread.sleep(1000);

        WebElement confirmButton= WebDriverSingleton.driver.findElement(Params2.BUTTON_CONFIRM);
        confirmButton.click();

        Thread.sleep(20000);

        String actualTitle = WebDriverSingleton.driver.getTitle();
        Assert.assertEquals( actualTitle.contains("ID"), true);
    }

    @AfterMethod
    public void close() {
        WebDriverSingleton.close();
    }
}
