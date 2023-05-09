package seleniumWebDriverTask40;

import org.openqa.selenium.By;

public class ParametersWaitForUser {
    public static final String URL = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";

    public static final By LINK_TO_GET_NEW_USER = By.xpath("//*[@id=\"save\"]");

    public static final By EXPLICIT_WAIT_SELECTOR = By.xpath("//*[@id=\"loading\"]");
}
