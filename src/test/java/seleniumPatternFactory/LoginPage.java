package seleniumPatternFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public static final String URL_LOGIN = "https://passport.yandex.com/auth?retpath=https%3A%2F%2Fpassport.yandex.com%2F&noreturn=1";

    @FindBy(id = "passp:sign-in")
    WebElement buttonLogIn;
    @FindBy (name = "login")
    WebElement fieldInputName;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username) throws InterruptedException {
        fieldInputName.sendKeys(username);
    }
    public void clickNext() throws InterruptedException {
        buttonLogIn.click();
    }
}
