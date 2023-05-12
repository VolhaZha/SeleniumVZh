package seleniumPatternFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private WebDriver driver;
    @FindBy(id = "passp:sign-in")
    WebElement buttonLogIn;
    @FindBy (name = "login")
    WebElement fieldInputName;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String username) throws InterruptedException {
        fieldInputName.sendKeys(username);
    }
    public void clickNext() throws InterruptedException {
        buttonLogIn.click();
    }
}
