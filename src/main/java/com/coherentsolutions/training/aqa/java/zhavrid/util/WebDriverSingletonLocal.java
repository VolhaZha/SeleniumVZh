package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TimeConstants;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class WebDriverSingletonLocal {
    public static WebDriver driver;
    public static ChromeOptions options;

    private WebDriverSingletonLocal() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initialize();
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        WebDriverSingletonLocal.driver = driver;
    }

    public static WebDriver initialize() {
        if (driver == null) {
            options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(options);
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeConstants.SECONDS_IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeConstants.SECONDS_PAGE_LOAD_TIMEOUT));
        driver.manage().window().maximize();

        return driver;

    }

     public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
