package seleniumWebDriverTask40;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class TestAlert {
    public WebDriver driver;
    public ChromeOptions options;

    @BeforeTest
    public void launchBrowser () {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
    }
    @Test (priority = 1)
    public void testConfirmOk() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get(ParametersAlert.URL);

        WebElement clickMeAlert = driver.findElement(ParametersAlert.LINK_TO_CLICK_ME_CONFIRM);
        clickMeAlert.click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);

        Thread.sleep(5000);

        driver.switchTo().alert().accept();
    }

    @Test (priority = 2)
    public void testConfirmCancel() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get(ParametersAlert.URL);

        WebElement clickMeAlert = driver.findElement(ParametersAlert.LINK_TO_CLICK_ME_CONFIRM);
        clickMeAlert.click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);

        Thread.sleep(5000);

        driver.switchTo().alert().dismiss();
    }

    @Test (priority = 4)
    public void testPrompt() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get(ParametersAlert.URL);

        WebElement clickForPromptAlert = driver.findElement(ParametersAlert.LINK_FOR_PROMPT);
        clickForPromptAlert.click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);

        Thread.sleep(5000);

        driver.switchTo().alert().sendKeys("OZ");
        driver.switchTo().alert().accept();
    }

    @Test (priority = 3)
    public void testAlert() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get(ParametersAlert.URL);

        WebElement clickMeAlert = driver.findElement(ParametersAlert.LINK_TO_CLICK_ME_ALERT);
        clickMeAlert.click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);

        Thread.sleep(5000);

        driver.switchTo().alert().accept();
    }

//    @AfterTest
//    public void terminateBrowser(){
//        driver.close();
//    }
}
