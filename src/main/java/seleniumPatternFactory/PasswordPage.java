package seleniumPatternFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends  BasePage{
    private WebDriver driver;

    @FindBy(css = "#passp\\:sign-in")
    WebElement buttonLogIn;

    @FindBy (xpath = "//*[@id=\"passp-field-passwd\"]")
    WebElement fieldInputPassword;

    public PasswordPage(WebDriver driver) {
        super(driver);
    }
    public PasswordPage enterPassword(String password) throws InterruptedException {
        fieldInputPassword.sendKeys(password);
        Thread.sleep(TimeConstants.MILLIS_WAIT_AFTER_PASSWORD_ENTER);
        return this;
    }
    public void clickNext() throws InterruptedException {
        buttonLogIn.click();
    }
}
