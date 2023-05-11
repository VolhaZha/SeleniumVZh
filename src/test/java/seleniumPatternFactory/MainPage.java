package seleniumPatternFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public static final String URL_LOGOUT = "https://passport.yandex.com/?ncrnd=56976";

    @FindBy(xpath = "//*[@class=\"Link UserID-Account\"]")
    WebElement iconAvatar;

    @FindBy (xpath = "//span[@class=\"Text\" and contains(text(), \"Sign out\")]")
    WebElement linkToSignOut;
    public static final By FRAME = By.xpath ("//*[@class=\"UserWidget-Iframe\"]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openMenu() {
        iconAvatar.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(WebDriverSingleton.driver.findElement(MainPage.FRAME));
    }

    public void clickQuit() throws InterruptedException {
        linkToSignOut.click();
    }
}
