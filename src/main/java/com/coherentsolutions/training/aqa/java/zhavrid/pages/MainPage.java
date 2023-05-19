package com.coherentsolutions.training.aqa.java.zhavrid.pages;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TimeConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class MainPage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "div[class='UserID-Avatar ']")
    private WebElement iconAvatar;

    @FindBy(css = "[aria-expanded='true']")
    private WebElement areaExpanded;

    @FindBy(xpath = "//iframe[@class='UserWidget-Iframe']")
    private WebElement frameElement;

    @FindBy (css = "div .Logout")
    private WebElement linkToSignOut;

    @FindBy(css = "div .Logout.ListItem_hovered")
    private WebElement hover;

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

    public MainPage hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        return this;
    }
    public LoginPage clickQuit(){

        driver.switchTo().frame(frameElement);

        hoverOverElement(driver, linkToSignOut);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeConstants.SECONDS_WAIT_LOGOUT))
                .pollingEvery(Duration.ofMillis(TimeConstants.MILLIS_DURATION))
                .ignoring(NoSuchElementException.class);
        wait.until(driver -> hover.isDisplayed());

        wait.until(driver -> ExpectedConditions.visibilityOf(linkToSignOut).apply(driver));

        linkToSignOut.click();

        driver.switchTo().defaultContent();

        return new LoginPage(driver);

    }
}
