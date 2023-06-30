package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TimeConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;

public class WebDriverSingleton {
    public static WebDriver driver;
    public static ChromeOptions options;

    private static final String USERNAME_SL_KEY = "username";
    private static final String ACCESSKEY_SL_KEY = "accessKey";

    private static String userNameSLVal;
    private static String accessKeySLVal;
    private static String urlSL;

    private static WebDriverSingleton instanceDriver  = null;


    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initialize();
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        WebDriverSingleton.driver = driver;
    }

    public synchronized static WebDriverSingleton getDriverInstance() {
        if (instanceDriver == null) {
            instanceDriver = new WebDriverSingleton();
        }
        return instanceDriver;
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

    public static WebDriver openDriverInSauceLabs(String browserName) throws IOException {

        userNameSLVal = PropertiesFileReader.getProperty(PropertyKey.USERNAMESL);
        accessKeySLVal = PropertiesFileReader.getProperty(PropertyKey.ACCESSKEYSL);

        System.out.println("browser name is: " + browserName);

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability(USERNAME_SL_KEY, PropertiesFileReader.getProperty(PropertyKey.USERNAMESL));
        sauceOpts.setCapability(ACCESSKEY_SL_KEY, PropertiesFileReader.getProperty(PropertyKey.ACCESSKEYSL));

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("sauce:options", sauceOpts);

        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.WIN10);
            cap.setVersion("latest");
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.WIN8_1);
            cap.setVersion("latest");
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            cap.setBrowserName("MicrosoftEdge");
            cap.setPlatform(Platform.WIN10);
            cap.setVersion("latest");
        }

        try {
            urlSL = PropertiesFileReader.getProperty(PropertyKey.URLSL);
            URL url = new URL (urlSL);
            return new RemoteWebDriver(url, cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create Sauce Labs driver instance");
        }
    }


    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
