package seleniumPatternPOM;

import org.openqa.selenium.By;

public class Params2 {
    public static final String URL_LOGIN = "https://passport.yandex.com/auth?retpath=https%3A%2F%2Fpassport.yandex.com%2F&noreturn=1";
    public static final By BUTTON_LOGIN_1 = By.id ("passp:sign-in");
    public static final By FIELD_INPUT_NAME = By.name("login");
    public static final By FIELD_INPUT_PASSWORD = By.xpath("//*[@id=\"passp-field-passwd\"]");
    public static final By BUTTON_LOGIN_2 = By.cssSelector("#passp\\:sign-in");
    public static final By BUTTON_CONFIRM = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div/div[3]/div/button");
    public static final By ICON_AVATAR = By.xpath ("//*[@id=\"__next\"]/div/header/div[4]/div/a[1]/div/div[1]");
    public static final By LINK_TO_SIGN_OUT = By.xpath ("//*[@id=\"root\"]/div/div/div/div[6]/div");
    public static final By FRAME = By.xpath ("//*[@id=\"__next\"]/div/header/div[4]/div/div/div/div/iframe");

    public static final String URL_LOGOUT = "https://passport.yandex.com/?ncrnd=56976";
}
