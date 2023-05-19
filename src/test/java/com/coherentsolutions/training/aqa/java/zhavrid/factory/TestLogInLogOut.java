package com.coherentsolutions.training.aqa.java.zhavrid.factory;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TestDataConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.constants.TimeConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.constants.UrlConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.LoginPage;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.MainPage;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.PasswordPage;
import com.coherentsolutions.training.aqa.java.zhavrid.util.Screen;
import com.coherentsolutions.training.aqa.java.zhavrid.util.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
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
    public void testLogIn() {

        loginPage.enterUserName(TestDataConstants.USER_NAME);
        loginPage.clickNext();

        passwordPage.enterPassword(TestDataConstants.PASSWORD);
        passwordPage.clickNext();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeConstants.MILLIS_WAIT_AFTER_PASSWORD_ENTER_AND_CLICK));
        wait.until(ExpectedConditions.titleContains(TestDataConstants.INFO_AFTER_LOGIN));

        String actualTitle = WebDriverSingleton.driver.getTitle();
        Assert.assertEquals( actualTitle.contains(TestDataConstants.INFO_AFTER_LOGIN), true);

    }

    @Test
    public void testLogout() {

        loginPage.enterUserName(TestDataConstants.USER_NAME);
        loginPage.clickNext();

        passwordPage.enterPassword(TestDataConstants.PASSWORD);
        passwordPage.clickNext();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeConstants.MILLIS_WAIT_AFTER_PASSWORD_ENTER_AND_CLICK));
        wait.until(ExpectedConditions.titleContains(TestDataConstants.INFO_AFTER_LOGIN));

        mainPage.openMenu();
        mainPage.clickQuit();

        String actualTitle = WebDriverSingleton.driver.getTitle();
        Assert.assertEquals(actualTitle, TestDataConstants.INFO_AFTER_LOGOUT, "Log out failed!");

    }

    @AfterMethod
    public void close() {
        try {
            WebDriverSingleton.close();
        }
        finally {
            System.out.println("Close() method completed!");
        }
    }
}
