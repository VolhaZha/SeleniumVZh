package com.coherentsolutions.training.aqa.java.zhavrid.base;

import com.coherentsolutions.training.aqa.java.zhavrid.util.WebDriverSingletonLocal;
import com.coherentsolutions.training.aqa.java.zhavrid.util.WebDriverSingletonRemote;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {
    private WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void launchBrowser(String browserName) throws IOException {
//        if (browserName.equals("sauceLabs")) {
//            driver = WebDriverSingleton.openDriverInSauceLabs(browserName);
//        } else {
//            driver = WebDriverSingleton.getDriver();
//        }

        driver = WebDriverSingletonRemote.openDriverInSauceLabs(browserName);

        WebDriverSingletonLocal.setDriver(driver);
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
