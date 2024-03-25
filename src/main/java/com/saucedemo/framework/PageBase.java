package com.saucedemo.framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Base64;

public class PageBase {
    protected WebDriver webDriver = DriverSetup.getWebDriverManagerInstance().getWebDriver();
    private WebDriverWait webDriverWait;

    protected WebElement waitUntilElementClickable(WebElement webElement) {
        webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(Constants.DEFAULT_EXPLICIT_WAIT_TIMEOUT));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitUntilElementVisible(WebElement webElement) {
        webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(Constants.DEFAULT_EXPLICIT_WAIT_TIMEOUT));
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void clickButton(WebElement elementToClick) {
        waitUntilElementVisible(elementToClick);
        waitUntilElementClickable(elementToClick);
        elementToClick.click();
    }

    protected String getWebElementText(WebElement webElement) {
        waitUntilElementVisible(webElement);
        return webElement.getText();
    }

    protected void inputText(String value, WebElement element) {
        waitUntilElementVisible(element);
        waitUntilElementClickable(element);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public static String takeScreenshot() {
        WebDriver driver = DriverSetup.getWebDriverManagerInstance().getWebDriver();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String pathToSaveScreenshot = System.getProperty("user.dir") + "\\target\\screenshots\\" + System.currentTimeMillis() + ".png";
        try {
            File filePathToSaveScreenshot = new File(pathToSaveScreenshot);
            FileUtils.copyFile(screenshotFile, filePathToSaveScreenshot);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshotFile);
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (Exception exception) {
            System.err.println(exception);
        }
        return null;
    }
}
