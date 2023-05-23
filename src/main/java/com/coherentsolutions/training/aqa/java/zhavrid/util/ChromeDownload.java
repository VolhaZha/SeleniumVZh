package com.coherentsolutions.training.aqa.java.zhavrid.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDownload {
    public static void chromeDownload() {
        String downloadPath = "C:\\Downloads";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("download.default_directory=" + downloadPath);

        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver");
        ChromeDriver driver = new ChromeDriver(options);
    }
}
