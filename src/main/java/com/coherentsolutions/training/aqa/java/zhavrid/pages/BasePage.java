package com.coherentsolutions.training.aqa.java.zhavrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
