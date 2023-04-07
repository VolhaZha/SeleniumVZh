package seleniumWebDriver;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestLogIn {

    @Test
    public void logIn() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        driver.get("https://passport.yandex.com/auth?retpath=https%3A%2F%2Fpassport.yandex.com%2F&noreturn=1");

        WebElement userName=driver.findElement(By.name(Locators.NAME));
        WebElement logInButton1=driver.findElement(By.id(Locators.ID));

        userName.sendKeys("ooozoz");
        logInButton1.click();

        WebElement password=driver.findElement(By.xpath(Locators.XPATH));
        password.sendKeys("1234567OZ!");
        WebElement logInButton2=driver.findElement(By.cssSelector(Locators.CSS_SELECTOR));
        logInButton2.click();

        String title = driver.getTitle();
        Assert.assertEquals("Authorization", title);

        driver.quit();
    }
}
