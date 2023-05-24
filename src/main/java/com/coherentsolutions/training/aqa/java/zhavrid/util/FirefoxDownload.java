package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TestDataConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxDownload extends BasePage implements DownloadManager {
    private String downloadPath;

    public FirefoxDownload(WebDriver driver) {
        super(driver);
    }

    public void firefoxDownload() {
        downloadPath = TestDataConstants.DOWNLOAD_PATH;

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", downloadPath);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        System.setProperty("webdriver.gecko.driver", "C:\\FireFoxDriver\\geckodriver");
        driver = new FirefoxDriver(options);
    }

    @Override
    public void download() {

    }

    @Override
    public String getDownloadPath() {
        return downloadPath;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
