package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TestDataConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class IEDownload extends BasePage implements DownloadManager {

    private String downloadPath;

    public IEDownload(WebDriver driver) {
        super(driver);
    }

    public void prepareDownload() {
        DownloadManagerFactory.createDownloadManager(BrowserType.IE, driver);
        DownloadManagerFactory.createWebDriver(BrowserType.IE);
        DownloadManagerFactory.modifyRegistrySettings(TestDataConstants.DOWNLOAD_PATH);
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
