package seleniumPatternFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
    private WebDriver driver;

    @FindBy (xpath = "//span[@class=\"Text\" and contains(text(), \"Sign out\")]")
    WebElement linkToSignOut;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickQuit() {
        linkToSignOut.click();
    }
}
