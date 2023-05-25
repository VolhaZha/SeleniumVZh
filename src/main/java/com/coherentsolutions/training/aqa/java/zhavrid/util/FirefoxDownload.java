package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class FirefoxDownload extends BasePage implements DownloadManager {
    private String downloadPath;

    public FirefoxDownload(WebDriver driver) {
        super(driver);
    }

    public void prepareDownload() {
        DownloadManagerFactory.createDownloadManager(BrowserType.FIREFOX, driver);
        DownloadManagerFactory.createWebDriver(BrowserType.FIREFOX);
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
