package seleniumPatternFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends  BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class=\"Link UserID-Account\"]")
    WebElement iconAvatar;

    @FindBy(xpath = "//*[@class=\"UserWidget-Iframe\"]")
    WebElement frameElement;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MenuPage openMenu() throws InterruptedException {
        iconAvatar.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameElement);
        return new MenuPage(driver);
    }
}
