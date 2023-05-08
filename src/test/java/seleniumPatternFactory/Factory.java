package seleniumPatternFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Factory {
    @FindBy(id = "passp:sign-in")
    WebElement buttonLogIn1;
    @FindBy (name = "login")
    WebElement fieldInputName;
    @FindBy (css = "#passp\\:sign-in")
    WebElement buttonLogIn2;
    @FindBy (xpath = "//*[@id=\"passp-field-passwd\"]")
    WebElement fieldInputPassword;
    @FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div/div[3]/div/button")
    WebElement buttonConfirm;
    @FindBy (xpath = "//*[@id=\"__next\"]/div/header/div[4]/div/a[1]/div/div[1]")
    WebElement iconAvatar;
    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div[6]/div")
    WebElement linkToSignOut;

    public void inputUsername(String username) {
        fieldInputName.sendKeys(username);
    }
    public void clickLogInButton1() {
        buttonLogIn1.click();
    }
    public void inputPassword(String password) {
        fieldInputPassword.sendKeys(password);
    }
    public void clickLogInButton2() {
        buttonLogIn2.click();
    }
    public void clickConfirm() {
        buttonConfirm.click();
    }
    public void clickAvatar() {
        iconAvatar.click();
    }
    public void clickSignOutButton() {
        linkToSignOut.click();
    }

}
