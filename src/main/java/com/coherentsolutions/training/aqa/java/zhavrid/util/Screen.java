package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import java.util.Date;

public class Screen {

    public Screen takeScreen () {
        Date currentdate = new Date ();
        String screenshotFileName = currentdate.toString().replace(" ", "-").replace(":", "-");

        Shutterbug.shootPage(WebDriverSingletonLocal.getDriver(), Capture.FULL, true).save(".//target//artifacts//screenshot//"+screenshotFileName+".png");

        return this;
    }
}
