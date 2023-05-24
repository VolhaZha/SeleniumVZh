package com.coherentsolutions.training.aqa.java.zhavrid.util;

import com.coherentsolutions.training.aqa.java.zhavrid.constants.TestDataConstants;
import com.coherentsolutions.training.aqa.java.zhavrid.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.IOException;

public class IEDownload extends BasePage {
    public IEDownload(WebDriver driver) {
        super(driver);
    }

    public static void iEDownload() {
        String downloadPath = TestDataConstants.DOWNLOAD_PATH;

        modifyRegistrySettings(downloadPath);

        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability("ie.ensureCleanSession", true);
        options.setCapability("ie.download.directory", downloadPath);
        options.setCapability("ie.download.promptForDownload", false);

        System.setProperty("webdriver.ie.driver", "C:\\IEDriver\\IEDriverServer");
        InternetExplorerDriver driver = new InternetExplorerDriver(options);
    }

    private static void modifyRegistrySettings(String downloadPath) {
        try {
            ProcessBuilder enableAutoDownloadProcess = new ProcessBuilder(
                    "reg", "add", "HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\Shell\\AttachmentExecute\\{0002DF01-0000-0000-C000-000000000046}",
                    "/v", "SaveToDisk", "/t", "REG_SZ", "/d", "always", "/f"
            );
            enableAutoDownloadProcess.start();

            ProcessBuilder setDownloadDirectoryProcess = new ProcessBuilder(
                    "reg", "add", "HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main",
                    "/v", "Default Download Directory", "/t", "REG_SZ", "/d", downloadPath, "/f"
            );
            setDownloadDirectoryProcess.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
