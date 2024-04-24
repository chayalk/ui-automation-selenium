package com.saucedemo.framework;

import com.saucedemo.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
    private WebDriver webDriver;

    private static DriverSetup singletonInstance;

    private DriverSetup() {

    }
    public static DriverSetup getWebDriverManagerInstance() {
        if (singletonInstance == null) {
            singletonInstance = new DriverSetup();
        }
        return singletonInstance;
    }

    public void startDriver() {
        if (PropertyReader.getProperty("browser.name").equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            webDriver = new ChromeDriver(options);
        } else if (PropertyReader.getProperty("browser.name").equalsIgnoreCase("firefox")) {
            webDriver = new FirefoxDriver();
        } else {
            System.exit(0);
        }
    }

    public void navigateToHomePage() {
        webDriver.manage().window().maximize();
        webDriver.get(PropertyReader.getProperty("home.page"));
    }

    public void quitDriver() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
