package seleniumPatternFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogInLogOut {
    private WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;

    @BeforeMethod
    public void launchBrowser() {
        driver = WebDriverSingleton.initialize();
        WebDriverSingleton.driver.get(UrlConstants.URL_LOGIN);

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void testLogIn() throws InterruptedException {
        try {

        loginPage.enterUserName(TestDataConstants.USER_NAME);
        loginPage.clickNext();

        passwordPage.enterPassword(TestDataConstants.PASSWORD);
        passwordPage.clickNext();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeConstants.MILLIS_WAIT_AFTER_PASSWORD_ENTER_AND_CLICK));
        wait.until(ExpectedConditions.titleContains(TestDataConstants.INFO_AFTER_LOGIN));

        String actualTitle = WebDriverSingleton.driver.getTitle();
        Assert.assertEquals( actualTitle.contains(TestDataConstants.INFO_AFTER_LOGIN), true);

        } finally {
            WebDriverSingleton.close();
        }
    }

    @Test
    public void testLogout() throws InterruptedException {
        try {

        loginPage.enterUserName(TestDataConstants.USER_NAME);
        loginPage.clickNext();

        passwordPage.enterPassword(TestDataConstants.PASSWORD);
        passwordPage.clickNext();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeConstants.MILLIS_WAIT_AFTER_PASSWORD_ENTER_AND_CLICK));
        wait.until(ExpectedConditions.titleContains(TestDataConstants.INFO_AFTER_LOGIN));

        mainPage.openMenu();
        mainPage.clickQuit();

        String actualTitle = WebDriverSingleton.driver.getTitle();
        Assert.assertEquals( actualTitle.contains(TestDataConstants.INFO_AFTER_LOGOUT), true);

        } finally {
            WebDriverSingleton.close();
        }
    }

    @AfterMethod
    public void close() {
        WebDriverSingleton.close();
    }
}
