package seleniumPatternFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(css = "iframe.UserWidget-Iframe")
    WebElement frameElement;

    @FindBy (css = "div .Logout")
    WebElement linkToSignOut;

    @FindBy(id = "passp:sign-in")
    WebElement buttonLogIn;

    @FindBy(css = "div .Logout.ListItem_hovered")
    WebElement hover;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MainPage openMenu() {
        iconAvatar.click();

        Wait<WebDriver> waitLogOut = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeConstants.SECONDS_WAIT_LOGOUT))
                .pollingEvery(Duration.ofMillis(TimeConstants.MILLIS_DURATION))
                .ignoring(NoSuchElementException.class);
        waitLogOut.until(driver -> areaExpanded.isDisplayed());

        return this;
    }

    public void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public LoginPage clickQuit(){
        Wait<WebDriver> waitFrame = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeConstants.SECONDS_WAIT_FRAME))
                .pollingEvery(Duration.ofMillis(TimeConstants.MILLIS_DURATION_FRAME))
                .ignoring(NoSuchElementException.class);

        waitFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));

        driver.switchTo().frame(frameElement);

        hoverOverElement(driver, linkToSignOut);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeConstants.SECONDS_WAIT_LOGOUT))
                .pollingEvery(Duration.ofMillis(TimeConstants.MILLIS_DURATION))
                .ignoring(NoSuchElementException.class);
        wait.until(driver -> hover.isDisplayed());

        wait.until(driver -> ExpectedConditions.visibilityOf(linkToSignOut).apply(driver));

        wait.until(ExpectedConditions.elementToBeClickable(linkToSignOut));

        linkToSignOut.click();

        driver.switchTo().defaultContent();

        wait.until(driver -> ExpectedConditions.elementToBeClickable(buttonLogIn).apply(driver));

        return new LoginPage(driver);

    }
}
