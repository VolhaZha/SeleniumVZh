package com.coherentsolutions.training.aqa.java.zhavrid.pages;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TimeConstants;
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
    public PasswordPage enterPassword(String password) throws InterruptedException {
        fieldInputPassword.sendKeys(password);
        Thread.sleep(TimeConstants.MILLIS_WAIT_AFTER_PASSWORD_ENTER);
        return this;
    }
    public MainPage clickNext() {
        buttonLogIn.click();
        return new MainPage(driver);
    }
}
