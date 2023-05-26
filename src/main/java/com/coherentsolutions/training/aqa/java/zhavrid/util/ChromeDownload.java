package com.coherentsolutions.training.aqa.java.zhavrid.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ChromeDownload implements DownloadManager {
    private String downloadPath;

    private WebDriver driver;

    public ChromeDownload (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void prepareDownload() {
        DownloadManagerFactory.createDownloadManager(BrowserType.CHROME, driver);
        DownloadManagerFactory.createWebDriver(BrowserType.CHROME);
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
