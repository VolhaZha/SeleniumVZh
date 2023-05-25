package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class ChromeDownload  extends BasePage implements DownloadManager {
    private String downloadPath;

    public ChromeDownload(WebDriver driver) {
        super(driver);
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
