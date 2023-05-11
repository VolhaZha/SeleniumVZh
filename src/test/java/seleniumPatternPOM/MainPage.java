package seleniumPatternPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public static final String URL_LOGOUT = "https://passport.yandex.com/?ncrnd=56976";

    public static final By ICON_AVATAR = By.xpath ("//*[@class=\"Link UserID-Account\"]");
    public static final By LINK_TO_SIGN_OUT = By.xpath ("//span[@class=\"Text\" and contains(text(), \"Sign out\")]");
    public static final By FRAME = By.xpath ("//*[@class=\"UserWidget-Iframe\"]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMenu() {
        WebElement avatarButton= driver.findElement(MainPage.ICON_AVATAR);
        avatarButton.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(WebDriverSingleton.driver.findElement(MainPage.FRAME));
    }

    public void clickQuit() throws InterruptedException {
        WebElement signOutButton= driver.findElement(MainPage.LINK_TO_SIGN_OUT);
        signOutButton.click();
    }
}

