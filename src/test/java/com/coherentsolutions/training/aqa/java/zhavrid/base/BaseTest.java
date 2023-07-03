package com.coherentsolutions.training.aqa.java.zhavrid.base;

import com.coherentsolutions.training.aqa.java.zhavrid.util.WebDriverSingletonLocal;
import com.coherentsolutions.training.aqa.java.zhavrid.util.WebDriverSingletonRemote;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {
    private WebDriver driver;

    @Parameters({"browser", "executionMode"})
    @BeforeMethod
    public void launchBrowser(String browserName, String executionMode) throws IOException {
        if (executionMode.equals("remote")) {
            driver = WebDriverSingletonRemote.openDriverInSauceLabs(browserName);
            WebDriverSingletonRemote.setDriver(driver);
            System.out.println(WebDriverSingletonRemote.getDriver().toString());
        } else {
            driver = WebDriverSingletonLocal.getDriver();
        }
        System.out.println(driver);
    }

    @AfterMethod
    public void close() {
        try {
            WebDriverSingletonLocal.close();
        }
        finally {
            System.out.println("Close() method completed!");
        }
    }
}
