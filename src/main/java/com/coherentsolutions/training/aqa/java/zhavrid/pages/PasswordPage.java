package com.coherentsolutions.training.aqa.java.zhavrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "#passp\\:sign-in")
    private WebElement buttonLogIn;

    @FindBy (xpath = "//*[@id=\"passp-field-passwd\"]")
    private WebElement fieldInputPassword;

    public PasswordPage(WebDriver driver) {
        super(driver);
    }
    public PasswordPage enterPassword(String password) {
        fieldInputPassword.sendKeys(password);
        return this;
    }
    public MainPage clickNext() {
        buttonLogIn.click();
        return new MainPage(driver);
    }
}
