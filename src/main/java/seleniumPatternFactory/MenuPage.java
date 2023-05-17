package seleniumPatternFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class MenuPage extends BasePage {
    private WebDriver driver;

    @FindBy (css = "div .Logout")
    WebElement linkToSignOut;

    @FindBy(id = "passp:sign-in")
    WebElement buttonLogIn;

    @FindBy(css = "div .Logout.ListItem_hovered")
    WebElement hover;

    public MenuPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void clickQuit(){
        hoverOverElement(driver, linkToSignOut);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeConstants.SECONDS_WAIT_LOGOUT))
                .pollingEvery(Duration.ofMillis(TimeConstants.MILLIS_DURATION))
                .ignoring(NoSuchElementException.class);
        wait.until(driver -> hover.isDisplayed());

        wait.until(driver -> ExpectedConditions.visibilityOf(linkToSignOut).apply(driver));

        wait.until(ExpectedConditions.elementToBeClickable(linkToSignOut));

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        linkToSignOut.sendKeys(Keys.ENTER);

        driver.switchTo().defaultContent();

        wait.until(driver -> ExpectedConditions.elementToBeClickable(buttonLogIn).apply(driver));

    }
}
