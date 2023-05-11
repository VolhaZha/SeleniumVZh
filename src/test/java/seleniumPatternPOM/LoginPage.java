package seleniumPatternPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public static final String URL_LOGIN = "https://passport.yandex.com/auth?retpath=https%3A%2F%2Fpassport.yandex.com%2F&noreturn=1";

    public static final By BUTTON_LOGIN = By.cssSelector ("#passp\\:sign-in");
    public static final By FIELD_INPUT_NAME = By.name("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) throws InterruptedException {
        WebElement usernameInput = driver.findElement(FIELD_INPUT_NAME);
        usernameInput.sendKeys(username);
    }
    public void clickNext() throws InterruptedException {
        WebElement loginButton = driver.findElement(BUTTON_LOGIN);
        loginButton.click();
    }
}
