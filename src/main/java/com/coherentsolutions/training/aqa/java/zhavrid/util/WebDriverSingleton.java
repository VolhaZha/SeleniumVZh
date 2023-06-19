package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TimeConstants;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverSingleton {
    public static WebDriver driver = null;
    public static ChromeOptions options;

    private WebDriverSingleton() {
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
            driver.close();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
