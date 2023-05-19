package com.coherentsolutions.training.aqa.java.zhavrid.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static com.coherentsolutions.training.aqa.java.zhavrid.util.WebDriverSingleton.driver;

public class Screen {

    public Screen takeScreen () {
        Date currentdate = new Date ();
        String screenshotFileName = currentdate.toString().replace(" ", "-").replace(":", "-");

        File screenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenFile, new File (".//screenshot//"+screenshotFileName+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
