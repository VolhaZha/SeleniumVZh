package com.coherentsolutions.training.aqa.java.zhavrid;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.UrlConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.DownloadPage;
import com.coherentsolutions.training.aqa.java.zhavrid.util.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDownload {
    private WebDriver driver;
    private DownloadPage downloadPage;

    @BeforeMethod
    public void launchBrowser() {
        driver = WebDriverSingleton.initialize();
        WebDriverSingleton.driver.get(UrlConstants.URL_DOWNLOAD);

        downloadPage = new DownloadPage(driver);
    }

    @Test
    public void testDownload() throws Exception {

        downloadPage.downloadPage();

        Assert.assertEquals(downloadPage.getContentType(), "application/octet-stream");
        Assert.assertNotEquals(downloadPage.getContentLength(), 0);

    }

    @AfterMethod
    public void close() {
        try {
            WebDriverSingleton.close();
        }
        finally {
            System.out.println("Close() method completed!");
        }
    }
}
