package com.coherentsolutions.training.aqa.java.zhavrid.factory;

import com.coherentsolutions.training.aqa.java.zhavrid.base.BaseTest;
import com.coherentsolutions.training.aqa.java.zhavrid.constants.TestDataConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.constants.TimeConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.LoginPage;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.MainPage;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.PasswordPage;
import com.coherentsolutions.training.aqa.java.zhavrid.util.AllureListener;
import com.coherentsolutions.training.aqa.java.zhavrid.util.PropertiesFileReader;
import com.coherentsolutions.training.aqa.java.zhavrid.util.PropertyKey;
import com.coherentsolutions.training.aqa.java.zhavrid.util.WebDriverSingletonLocal;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners({ AllureListener.class })
public class TestLogInLogOut extends BaseTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;

    private String browserInfo;

    private String userName;
    private String password;

    @Test (testName = "TestLogInLogOut.testLogIn")
    @Feature("Login")
    @Story("User Login")
    @Description("Test the login functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogIn() {
        driver = WebDriverSingletonLocal.getDriver();

        String url = PropertiesFileReader.getProperty(PropertyKey.URLLOGIN);
        WebDriverSingletonLocal.driver.get(url);

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);

        userName = PropertiesFileReader.getProperty(PropertyKey.USER);
        password = PropertiesFileReader.getProperty(PropertyKey.PASSWORD);

        loginPage.enterUserName(userName);
        loginPage.clickNext();

        passwordPage.enterPassword(password);
        passwordPage.clickNext();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeConstants.MILLIS_WAIT_AFTER_PASSWORD_ENTER_AND_CLICK));
        wait.until(ExpectedConditions.titleContains(TestDataConstants.INFO_AFTER_LOGIN));

        String actualTitle = WebDriverSingletonLocal.driver.getTitle();
        Assert.assertEquals(actualTitle.contains(TestDataConstants.INFO_AFTER_LOGIN), true);

    }

    @Test (testName = "TestLogInLogOut.testLogout")
    @Feature("Logout")
    @Story("User Logout")
    @Description("Test the logout functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogout() {
        driver = WebDriverSingletonLocal.getDriver();

        String url = PropertiesFileReader.getProperty(PropertyKey.URLLOGIN);
        WebDriverSingletonLocal.driver.get(url);

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);

        userName = PropertiesFileReader.getProperty(PropertyKey.USER);
        password = PropertiesFileReader.getProperty(PropertyKey.PASSWORD);

        loginPage.enterUserName(userName);
        loginPage.clickNext();

        passwordPage.enterPassword(password);
        passwordPage.clickNext();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeConstants.MILLIS_WAIT_AFTER_PASSWORD_ENTER_AND_CLICK));
        wait.until(ExpectedConditions.titleContains(TestDataConstants.INFO_AFTER_LOGIN));

        mainPage.openMenu();
        mainPage.clickQuit();

        String actualTitle = WebDriverSingletonLocal.driver.getTitle();
        Assert.assertEquals(actualTitle, TestDataConstants.INFO_AFTER_LOGOUT, "Log out failed!");

    }
}
