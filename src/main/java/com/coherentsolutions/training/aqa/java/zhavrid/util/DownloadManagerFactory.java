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

import java.io.IOException;

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
                modifyRegistrySettings(TestDataConstants.DOWNLOAD_PATH);
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setCapability("ie.ensureCleanSession", true);
                ieOptions.setCapability("ie.download.directory", TestDataConstants.DOWNLOAD_PATH);
                ieOptions.setCapability("ie.download.promptForDownload", false);
                System.setProperty("webdriver.ie.driver", "C:\\IEDriver\\IEDriverServer");
                driver = new InternetExplorerDriver(ieOptions);
                break;
        }

        return driver;
    }

    public static void modifyRegistrySettings(String downloadPath) {
        try {
            ProcessBuilder enableAutoDownloadProcess = new ProcessBuilder(
                    "reg", "add", "HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\Shell\\AttachmentExecute\\{0002DF01-0000-0000-C000-000000000046}",
                    "/v", "SaveToDisk", "/t", "REG_SZ", "/d", "always", "/f"
            );
            enableAutoDownloadProcess.start();

            ProcessBuilder setDownloadDirectoryProcess = new ProcessBuilder(
                    "reg", "add", "HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main",
                    "/v", "Default Download Directory", "/t", "REG_SZ", "/d", downloadPath, "/f"
            );
            setDownloadDirectoryProcess.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

