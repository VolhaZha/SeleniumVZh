package seleniumWebDriverTask40;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestScript9 {
    public static WebDriver driver;
    public ChromeOptions options;

    @BeforeTest
    public void launchBrowser() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
    }

    @Test(priority = 1)
    public void waitForUser() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        driver.get(ParametersScript9.URL);

        WebElement listNumberOption = driver.findElement(ParametersScript9.LIST_OPTION10);
        listNumberOption.click();

        Thread.sleep(1000);

        List<CustomObject> customObjectsList = new ArrayList<>();
        Boolean isButtonDisabled = driver.findElement(ParametersScript9.NEXTBUTTON).getAttribute("class").contains("disabled");
        while (!isButtonDisabled) {
            System.out.println();
            List<WebElement> rows = driver.findElements(ParametersScript9.ROWS);
            WebElement nextButton;
            nextButton = driver.findElement(ParametersScript9.NEXTBUTTON);

                for (WebElement row : rows) {
                    List<WebElement> cells = row.findElements(ParametersScript9.CELLS);
                    String name = cells.get(0).getText();
                    String position = cells.get(1).getText();
                    String office = cells.get(2).getText();
                    int ageValue = Integer.parseInt(cells.get(3).getText());
                    int salaryValue = Integer.parseInt(cells.get(5).getText().replaceAll("\\D", ""));

                    int x = 18;
                    int y = 400000;

                    if (ageValue > x && salaryValue <= y) {
                        CustomObject customObject = new CustomObject(name, position, office);
                        customObjectsList.add(customObject);
                    }
                }
                isButtonDisabled  = driver.findElement(ParametersScript9.NEXTBUTTON).getAttribute("class").contains("disabled");
                nextButton.click();
                Thread.sleep(1000);
        }

        for (CustomObject customObject : customObjectsList) {
            System.out.println(customObject.getName() + ", " + customObject.getPosition() + ", " + customObject.getOffice());

        }
    }
}
