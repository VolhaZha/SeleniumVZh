package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TimeConstants;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;

public class WebDriverSingleton {
    public static WebDriver driver = null;
    public static ChromeOptions options;

    private WebDriverSingleton() {
    }

    private static String url;

    public static WebDriver initialize() {
        url = PropertiesFileReader.getProperty("Property.URLhub");

        if (driver == null) {
            options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
           // driver = new ChromeDriver(options);
            try {
                String browser = PropertiesFileReader.getProperty("Property.BROWSER");
                if (browser.equalsIgnoreCase("chrome")) {
                    driver = new RemoteWebDriver(new URL(url), options);
                } else if (browser.equalsIgnoreCase("firefox")) {
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
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
