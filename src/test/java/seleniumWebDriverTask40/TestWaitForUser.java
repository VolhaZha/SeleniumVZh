package seleniumWebDriverTask40;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWaitForUser {
    public WebDriver driver;
    public ChromeOptions options;

    @BeforeTest
    public void launchBrowser () {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
    }

    @Test(priority = 1)
    public void waitForUser() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get(ParametersWaitForUser.URL);

        WebElement getNewUserButton = driver.findElement(ParametersWaitForUser.LINK_TO_GET_NEW_USER);
        getNewUserButton.click();

        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ParametersWaitForUser.EXPLICIT_WAIT_SELECTOR));
    }

    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}
