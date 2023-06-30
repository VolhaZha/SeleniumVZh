package com.coherentsolutions.training.aqa.java.zhavrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "passp:sign-in")
    private WebElement buttonLogIn;
    @FindBy (name = "login")
    private WebElement fieldInputName;

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    public LoginPage enterUserName(String username) {
        fieldInputName.sendKeys(username);
        return this;
    }
    public PasswordPage clickNext() {
        buttonLogIn.click();
        return new PasswordPage(driver);
    }
}
