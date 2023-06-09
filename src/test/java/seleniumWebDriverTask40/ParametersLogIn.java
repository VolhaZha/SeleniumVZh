package seleniumWebDriverTask40;

import org.openqa.selenium.By;

public class ParametersLogIn {
    public static final String URL = "https://passport.yandex.com/auth?retpath=https%3A%2F%2Fpassport.yandex.com%2F&noreturn=1";

    public static final String LINK_TEXT = null;
    public static final String PARTIAL_LINK_TEXT = null;
    public static final String TAG_NAME = null;
    public static final String CLASS_NAME = null;

    public static final By BUTTON_LOGIN_1 = By.id ("passp:sign-in");
    public static final By FIELD_INPUT_NAME = By.name("login");
    public static final By FIELD_INPUT_PASSWORD = By.xpath("//*[@id=\"passp-field-passwd\"]");
    public static final By BUTTON_LOGIN_2 = By.cssSelector("#passp\\:sign-in");
    public static final By EXPLICIT_WAIT_SELECTOR = By.xpath("//*[@id=\"__next\"]/div/header/div[4]/div/a[1]/div");
}

