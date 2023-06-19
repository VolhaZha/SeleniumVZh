package com.coherentsolutions.training.aqa.java.zhavrid.util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Date;

public class AllureListener implements ITestListener {
    private static  String getTestMethodName (ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment (value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Timestamp log", type = "text/plain")
    public static String saveTimestampLog() {
        Date d = new Date();
        String[] dateTokens = d.toString().split(" ");
        return dateTokens[1] + " " + dateTokens[2] + ", " + dateTokens[5] + " " + dateTokens[3];
    }

    @Attachment(value = "Browser info", type = "text/plain")
    public static String saveBrowserInfo(Capabilities capabilities) {
        String browserName = capabilities.getBrowserName();
        String browserVersion = capabilities.getBrowserVersion();
        return "Browser: " + browserName + " (Version: " + browserVersion + ")";
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver driver = WebDriverSingleton.getDriver();
        if (driver instanceof WebDriver){
            System.out.println("Screen captured for: " + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }

        saveTimestampLog();

        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        saveBrowserInfo(capabilities);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void addFailedStep(ITestResult result) {
    }

}
