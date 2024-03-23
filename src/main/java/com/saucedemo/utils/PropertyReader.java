package com.saucedemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static Properties prop;

    public static String getProperty(String propertyName) {
        prop = new Properties();
        try {
            InputStream propertyFileStream = PropertyReader.class.getClassLoader().getResourceAsStream("e2e.properties");
            if (propertyFileStream != null) {
                prop.load(propertyFileStream);
                return prop.getProperty(propertyName);
            }

        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }
}
