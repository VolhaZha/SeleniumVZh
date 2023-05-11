package seleniumPatternFactory;

import org.openqa.selenium.WebDriver;

public class Factory {
    private WebDriver driver;

    public Factory (WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public PasswordPage getPasswordPage() {
        return new PasswordPage(driver);
    }

    public MainPage getMainPage() {
        return new MainPage(driver);
    }

}
