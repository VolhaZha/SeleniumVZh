package com.coherentsolutions.training.aqa.java.zhavrid.pages;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class DownloadPage extends BasePage {

    public String getContentType() {
        return contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    private String contentType;
    private int contentLength;
    @FindBy(css = ".example a:nth-of-type(14)")
    private WebElement linkTODonwload;

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public DownloadPage downloadPage() throws IOException {
        String link = linkTODonwload.getAttribute("href");

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(link);
        HttpResponse response = httpClient.execute(request);

        contentType = response.getFirstHeader("Content-Type").getValue();
        contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());

        return new DownloadPage(driver);
    }
}
