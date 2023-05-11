package seleniumPatternPOM;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogInLogOut {
    private WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;

    @BeforeMethod
    public void launchBrowser() {
        driver = WebDriverSingleton.initialize();
        WebDriverSingleton.driver.get(LoginPage.URL_LOGIN);

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test(priority = 1)
    public void testLogIn() throws InterruptedException {
        loginPage.enterUserName("ooozoz8");
        loginPage.clickNext();

        passwordPage.enterPassword("1234567Oz!");
        loginPage.clickNext();

        Thread.sleep(20000);

        String actualTitle = WebDriverSingleton.driver.getTitle();
        Assert.assertEquals( actualTitle.contains("ID"), true);
    }

    @Test(priority = 2)
    public void testLogout() throws InterruptedException {
        testLogIn();
        mainPage.openMenu();
        mainPage.clickQuit();

        String actualTitle = WebDriverSingleton.driver.getTitle();
        Assert.assertEquals( actualTitle.contains("Authorization"), true);
    }

    @AfterMethod
    public void close() {
        WebDriverSingleton.close();
    }
}
