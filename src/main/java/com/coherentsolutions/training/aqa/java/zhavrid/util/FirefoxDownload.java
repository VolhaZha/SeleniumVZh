package com.coherentsolutions.training.aqa.java.zhavrid.util;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxDownload {
    public static void firefoxDownload () {
        String downloadPath = "C:\\Downloads";

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", downloadPath);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        System.setProperty("webdriver.gecko.driver", "C:\\FireFoxDriver\\geckodriver");
        FirefoxDriver driver = new FirefoxDriver(options);
    }
}
