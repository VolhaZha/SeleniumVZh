package seleniumPatternPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public static final String URL_LOGOUT = "https://passport.yandex.com/?ncrnd=56976";

    public static final By ICON_AVATAR = By.xpath ("//*[@id=\"__next\"]/div/header/div[4]/div/a[1]/div/div[1]");
    public static final By LINK_TO_SIGN_OUT = By.xpath ("//*[@id=\"root\"]/div/div/div/div[6]/div");
    public static final By FRAME = By.xpath ("//*[@id=\"__next\"]/div/header/div[4]/div/div/div/div/iframe");

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

