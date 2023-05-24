package com.coherentsolutions.training.aqa.java.zhavrid.util;

import org.openqa.selenium.WebDriver;

public interface DownloadManager {
    void download();
    String getDownloadPath();
    WebDriver getDriver();
}
