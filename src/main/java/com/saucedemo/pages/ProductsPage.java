package com.saucedemo.pages;

import com.saucedemo.framework.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends PageBase {

    public ProductsPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "title")
    WebElement productPageTitle;

    public boolean productPageVisible() {
        WebElement webElement = waitUntilElementVisible(productPageTitle);
        if (webElement.getText().equals("Products")) {
            return true;
        }
        return false;
    }
}
