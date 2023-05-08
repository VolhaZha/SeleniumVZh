package seleniumWebDriverTask40;

import org.openqa.selenium.By;

public class ParametersDownloadProgress {
    public static final String URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";

    public static final By DOWNLOAD_BUTTON = By.xpath("//*[@id=\"cricle-btn\"]");

    public static final By LINK_TO_PERCENTAGE = By.xpath("//div[@class='percenttext'][text()='50%'] ");
}
