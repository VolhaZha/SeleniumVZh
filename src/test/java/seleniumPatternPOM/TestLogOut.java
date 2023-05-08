package seleniumPatternPOM;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogOut {
    @BeforeMethod
    public void launchBrowser() throws InterruptedException {
        WebDriverSingleton.initialize();
        TestLogIn logIn = new TestLogIn();
        logIn.testLogIn();
    }

    @Test(priority = 2)
    public void testLogOut() throws InterruptedException {
        WebDriverSingleton.driver.get(Params2.URL_LOGOUT);

        WebElement avatarButton= WebDriverSingleton.driver.findElement(Params2.ICON_AVATAR);
        avatarButton.click();

        WebDriverSingleton.driver.switchTo().defaultContent();
        WebDriverSingleton.driver.switchTo().frame(WebDriverSingleton.driver.findElement(Params2.FRAME));
        WebElement signOutButton= WebDriverSingleton.driver.findElement(Params2.LINK_TO_SIGN_OUT);
        signOutButton.click();
    }

    @AfterMethod
    public void close() {
        WebDriverSingleton.close();
    }
}
