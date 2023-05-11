package seleniumPatternFactory;

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
    private seleniumPatternFactory.Factory factory;

    @BeforeMethod
    public void launchBrowser() {
        driver = WebDriverSingleton.initialize();
        WebDriverSingleton.driver.get(LoginPage.URL_LOGIN);

        factory = new seleniumPatternFactory.Factory(driver);

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test(priority = 1)
    public void testLogIn() throws InterruptedException {
        loginPage = factory.getLoginPage();
        loginPage.enterUserName("ooozoz");
        loginPage.clickNext();

        passwordPage = factory.getPasswordPage();
        passwordPage.enterPassword("1234567Oz!!!");
        passwordPage.clickNext();

        Thread.sleep(20000);

        String actualTitle = WebDriverSingleton.driver.getTitle();
        Assert.assertEquals( actualTitle.contains("ID"), true);
    }

    @Test(priority = 2)
    public void testLogout() throws InterruptedException {

        loginPage = factory.getLoginPage();
        loginPage.enterUserName("ooozoz");
        loginPage.clickNext();

        passwordPage = factory.getPasswordPage();
        passwordPage.enterPassword("1234567Oz!!!");
        passwordPage.clickNext();

        Thread.sleep(20000);

        mainPage = factory.getMainPage();
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
