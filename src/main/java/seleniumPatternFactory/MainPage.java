package seleniumPatternFactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class MainPage extends  BasePage {
    private WebDriver driver;

    @FindBy(css = "div[class='UserID-Avatar ']")
    WebElement iconAvatar;

    @FindBy(css = "[aria-expanded='true']")
    WebElement areaExpanded;

    @FindBy(xpath = "//iframe[@class='UserWidget-Iframe']")
    WebElement frameElement;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MenuPage openMenu() {
        Wait<WebDriver> waitFrame = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeConstants.SECONDS_WAIT_FRAME))
                .pollingEvery(Duration.ofMillis(TimeConstants.MILLIS_DURATION_FRAME))
                .ignoring(NoSuchElementException.class);

        iconAvatar.click();

        Wait<WebDriver> waitLogOut = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeConstants.SECONDS_WAIT_LOGOUT))
                .pollingEvery(Duration.ofMillis(TimeConstants.MILLIS_DURATION))
                .ignoring(NoSuchElementException.class);
        waitLogOut.until(driver -> areaExpanded.isDisplayed());

        waitFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));

        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameElement);

        return new MenuPage(driver);
    }
}
