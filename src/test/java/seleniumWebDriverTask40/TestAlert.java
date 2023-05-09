package seleniumWebDriverTask40;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestAlert {
    public WebDriver driver;
    public ChromeOptions options;

    @BeforeMethod
    public void launchBrowser () {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Test (priority = 1)
    public void testConfirmOk() throws InterruptedException {
        driver.get(ParametersAlert.URL);

        WebElement clickMeAlert = driver.findElement(ParametersAlert.BUTTON_CLICK_ME_CONFIRM);
        clickMeAlert.click();

        String expectedAlertText = "Press a button!";
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText, actualAlertText);

        Thread.sleep(5000);

        driver.switchTo().alert().accept();
    }

    @Test (priority = 2)
    public void testConfirmCancel() throws InterruptedException {
        driver.get(ParametersAlert.URL);

        WebElement clickMeAlert = driver.findElement(ParametersAlert.BUTTON_CLICK_ME_CONFIRM);
        clickMeAlert.click();

        String expectedAlertText = "Press a button!";
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText, actualAlertText);

        Thread.sleep(5000);

        driver.switchTo().alert().dismiss();
    }

    @Test (priority = 4)
    public void testPrompt() throws InterruptedException {
        driver.get(ParametersAlert.URL);

        WebElement clickForPromptAlert = driver.findElement(ParametersAlert.BUTTON_CLICK_FOR_PROMPT);
        clickForPromptAlert.click();

        String expectedAlertText = "Please enter your name";
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText, actualAlertText);

        Thread.sleep(5000);

        driver.switchTo().alert().sendKeys("OZ");
        driver.switchTo().alert().accept();
    }

    @Test (priority = 3)
    public void testAlert() throws InterruptedException {
        driver.get(ParametersAlert.URL);

        WebElement clickMeAlert = driver.findElement(ParametersAlert.BUTTON_CLICK_ME_ALERT);
        clickMeAlert.click();

        String expectedAlertText = "I am an alert box!";
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText, actualAlertText);

        Thread.sleep(5000);

        driver.switchTo().alert().accept();
    }

    @AfterMethod
    public void terminateBrowser(){
        driver.close();
    }
}
