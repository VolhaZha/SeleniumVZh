package com.coherentsolutions.training.aqa.java.zhavrid.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

    private static Properties prop;
    private static final String PROPERTIES_PATH = "src/main/resources/testdata.properties";

    private PropertiesFileReader() {
    }

    public static Properties getProperties() {
        if (prop == null) {
            try (InputStream input = new FileInputStream(PROPERTIES_PATH)) {
                prop = new Properties();
                prop.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return prop;
    }

    public static String getProperty(String key) {
        return getProperties().getProperty(key);
    }

}
