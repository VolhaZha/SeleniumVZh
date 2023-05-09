package seleniumWebDriverTask40;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogIn {

    @Test (dataProvider = "LoginDataProvider")
    public void testLogIn(String username, String pass) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get(ParametersLogIn.URL);

        WebElement userName=driver.findElement(ParametersLogIn.FIELD_INPUT_NAME);
        WebElement logInButton1=driver.findElement(ParametersLogIn.BUTTON_LOGIN_1);

        userName.sendKeys(username);
        logInButton1.click();

        WebElement password=driver.findElement(ParametersLogIn.FIELD_INPUT_PASSWORD);
        password.sendKeys(pass);
        WebElement logInButton2=driver.findElement(ParametersLogIn.BUTTON_LOGIN_2);
        logInButton2.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ParametersLogIn.EXPLICIT_WAIT_SELECTOR));

        //fluent waiter
        Wait<WebDriver> waitFluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        waitFluentWait.until(ExpectedConditions.visibilityOfElementLocated(ParametersLogIn.EXPLICIT_WAIT_SELECTOR));

        String actualTitle = driver.getTitle();
        Assert.assertEquals( actualTitle.contains("ID"), true);

        driver.close();
    }

    @DataProvider (name = "LoginDataProvider")
    public  Object [][] getData () {
        Object[][] data = {{"ooozoz3", "1234567OZ!!!"}, {"ooozoz", "1234567Oz!!!"}};
        return data;
    }
}
