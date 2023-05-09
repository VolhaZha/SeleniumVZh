package seleniumWebDriverTask40;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestDownloadProgress {
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

    @Test(priority = 1)
    public void waitForUser() throws InterruptedException {
        driver.get(ParametersDownloadProgress.URL);

        WebElement downloadButton = driver.findElement(ParametersDownloadProgress.DOWNLOAD_BUTTON);
        downloadButton.click();

        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ParametersDownloadProgress.LINK_TO_PERCENTAGE));

        driver.navigate().refresh();
    }

    @AfterMethod
    public void terminateBrowser(){
        driver.close();
    }
}
