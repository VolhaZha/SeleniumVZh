package seleniumPatternFactory;

import org.openqa.selenium.By;

public class Params1 {
    public static final String URLLOGIN = "https://passport.yandex.com/auth?retpath=https%3A%2F%2Fpassport.yandex.com%2F&noreturn=1";
    public static final String URLLOGOUT = "https://passport.yandex.com/?ncrnd=56976";
    public static final By FRAME = By.xpath ("//*[@id=\"__next\"]/div/header/div[4]/div/div/div/div/iframe");
}
