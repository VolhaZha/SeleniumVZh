package com.coherentsolutions.training.aqa.java.zhavrid;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.UrlConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.DownloadPage;
import com.coherentsolutions.training.aqa.java.zhavrid.util.DownloadInfo;
import com.coherentsolutions.training.aqa.java.zhavrid.util.WebDriverSingleton;
import org.apache.http.HttpResponse;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestDownload {
    private WebDriver driver;
    private DownloadPage downloadPage;

    public String getContentType() {
        return contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    private String contentType;
    private int contentLength;

    @BeforeMethod
    public void launchBrowser() {
        driver = WebDriverSingleton.initialize();
        WebDriverSingleton.driver.get(UrlConstants.URL_DOWNLOAD);

        downloadPage = new DownloadPage(driver);

    }

    @Test
    public void testDownload() throws Exception {
        HttpResponse response = downloadPage.downloadPage();

        contentType = response.getFirstHeader((String) DownloadInfo.CONTENT_TYPE.getValue()).getValue();
        contentLength = Integer.parseInt(response.getFirstHeader((String) DownloadInfo.CONTENT_LENGTH.getValue()).getValue());

        Assert.assertEquals(getContentType(), "application/octet-stream");
        Assert.assertNotEquals(getContentLength(), 0);

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
