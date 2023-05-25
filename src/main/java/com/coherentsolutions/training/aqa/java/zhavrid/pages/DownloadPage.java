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

    @FindBy(css = ".example a:nth-of-type(10)")
    private WebElement linkTODownload;

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public HttpResponse downloadPage() throws IOException {

       linkTODownload.click();

        String link = linkTODownload.getAttribute("href");
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(link);
        HttpResponse response = httpClient.execute(request);

        return response;
    }
}
