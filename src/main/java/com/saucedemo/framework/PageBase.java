package com.saucedemo.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
}
