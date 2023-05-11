package seleniumPatternPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordPage {
    private WebDriver driver;
    public static final By FIELD_INPUT_PASSWORD = By.xpath("//*[@id=\"passp-field-passwd\"]");
    public static final By BUTTON_LOGIN = By.cssSelector (".Button2_type_submit");

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterPassword(String password) throws InterruptedException {
        WebElement passwordInput = driver.findElement(FIELD_INPUT_PASSWORD);
        passwordInput.sendKeys(password);
        Thread.sleep(1000);
    }
    public void clickNext() throws InterruptedException {
        WebElement loginButton = driver.findElement(BUTTON_LOGIN);
        loginButton.click();
    }
}

