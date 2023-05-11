package seleniumPatternFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
    private WebDriver driver;

    @FindBy(css = "#passp\\:sign-in")
    WebElement buttonLogIn;

    @FindBy (xpath = "//*[@id=\"passp-field-passwd\"]")
    WebElement fieldInputPassword;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterPassword(String password) throws InterruptedException {
        fieldInputPassword.sendKeys(password);
        Thread.sleep(1000);
    }
    public void clickNext() throws InterruptedException {
        buttonLogIn.click();
    }
}
