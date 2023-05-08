package seleniumWebDriverTask40;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMultiselect {
    @Test
    public void multiSelect () throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get(ParametersMultiselct.URL);

        WebElement list=driver.findElement(ParametersMultiselct.LIST);
        Select select = new Select(list);

        select.selectByIndex(0);
        select.selectByIndex(1);
        select.selectByValue("Washington");
        select.selectByVisibleText("Texas");

        Thread.sleep(3000);
        select.deselectByIndex(0);

        Thread.sleep(3000);
        List<WebElement> allSelected = select.getAllSelectedOptions();
        List <String> actualOptionText = new ArrayList<String>();
        List <String> expectedOptionText = Arrays.asList("Florida", "Texas", "Washington");
        for (WebElement webElement : allSelected) {
            System.out.println(webElement.getText());
            actualOptionText.add(webElement.getText());
        }
        Assert.assertEquals(actualOptionText, expectedOptionText, "Selected option doesn't match expected option");
    }
}
