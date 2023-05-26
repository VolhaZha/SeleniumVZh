package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TestDataConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DownloadManagerFactory {
    public static DownloadManager createDownloadManager(BrowserType browserType, WebDriver driver) {

        DownloadManager downloadManager = null;

        switch (browserType) {
            case CHROME:
                downloadManager = new ChromeDownload(driver);
                break;
            case FIREFOX:
                downloadManager = new FirefoxDownload(driver);
                break;
            case IE:
                downloadManager = new IEDownload(driver);
                break;
        }

        return downloadManager;
    }

    public static WebDriver createWebDriver(BrowserType browserType) {
        WebDriver driver = null;

        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("download.default_directory=" + TestDataConstants.DOWNLOAD_PATH);
                System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver");
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.download.folderList", 2);
                profile.setPreference("browser.download.dir", TestDataConstants.DOWNLOAD_PATH);
                profile.setPreference("browser.download.manager.showWhenStarting", false);
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(profile);
                System.setProperty("webdriver.gecko.driver", "C:\\FireFoxDriver\\geckodriver");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case IE:
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setCapability("requireWindowFocus", true);
                ieOptions.setCapability("ie.usePerProcessProxy", true);
                ieOptions.setCapability("ie.ensureCleanSession", true);
                ieOptions.setCapability("ie.browserCommandLineSwitches", "-private");
                ieOptions.setCapability("ie.forceCreateProcessApi", true);
                ieOptions.setCapability("ie.fileUploadDialogTimeout", 0);
                ieOptions.setCapability("ie.download.directory_upgrade", true);
                ieOptions.setCapability("ie.download.prompt_for_download", false);
                ieOptions.setCapability("ie.download.default_directory", TestDataConstants.DOWNLOAD_PATH);

                System.setProperty("webdriver.ie.driver", "C:\\IEDriver\\IEDriverServer");
                driver = new InternetExplorerDriver(ieOptions);
                break;
        }

        return driver;
    }

}

