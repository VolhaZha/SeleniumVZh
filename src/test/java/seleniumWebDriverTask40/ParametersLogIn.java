package seleniumWebDriverTask40;

import org.openqa.selenium.By;

public class ParametersLogIn {
    public static final String URL = "https://passport.yandex.com/auth?retpath=https%3A%2F%2Fpassport.yandex.com%2F&noreturn=1";

    public static final String LINK_TEXT = null;
    public static final String PARTIAL_LINK_TEXT = null;
    public static final String TAG_NAME = null;
    public static final String CLASS_NAME = null;

    public static final By ID_LINK_TO_SIGN_IN = By.id ("passp:sign-in");
    public static final By INPUT_NAME = By.name("login");
    public static final By PASS_XPATH = By.xpath("//*[@id=\"passp-field-passwd\"]");
    public static final By CSS_SELECTOR_TO_SIGN_IN = By.cssSelector("#passp\\:sign-in");
    public static final By EXPLICIT_WAIT_SELECTOR = By.xpath("//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[1]/div/div/div[3]/div/div/a[1]/span[1]");
}

