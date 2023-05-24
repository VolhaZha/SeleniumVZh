package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TestDataConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDownload  extends BasePage implements DownloadManager {
    private String downloadPath;

    public ChromeDownload(WebDriver driver) {
        super(driver);
    }

    public void chromeDownload() {
        downloadPath = TestDataConstants.DOWNLOAD_PATH;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("download.default_directory=" + downloadPath);

        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver");
        ChromeDriver driver = new ChromeDriver(options);
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
