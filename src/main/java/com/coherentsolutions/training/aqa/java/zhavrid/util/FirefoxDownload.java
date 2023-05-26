package com.coherentsolutions.training.aqa.java.zhavrid.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FirefoxDownload implements DownloadManager {
    private String downloadPath;

    private WebDriver driver;

    public FirefoxDownload (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
