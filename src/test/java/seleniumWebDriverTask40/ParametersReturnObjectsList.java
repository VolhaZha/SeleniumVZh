package seleniumWebDriverTask40;

import org.openqa.selenium.By;

public class ParametersReturnObjectsList {

    public static final String URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    public static final By LIST_OPTION10 = By.xpath("//*[@id=\"example_length\"]/label/select/option[1]");
    public static final By ROWS = By.xpath("//table[@id='example']/tbody/tr");
    public static final By CELLS = By.tagName("td");
    public static final By NEXTBUTTON = By.xpath("//*[@id=\"example_next\"]");

}
