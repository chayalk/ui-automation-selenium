package com.saucedemo.pages;

import com.saucedemo.framework.PageBase;
import com.saucedemo.utils.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends PageBase {

    public ProductsPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "title")
    WebElement productPageTitle;

    @FindBy(className = "app_logo")
    WebElement AppLogo;

    public boolean productPageVisible() {
        WebElement webElement = waitUntilElementVisible(productPageTitle);
        if (webElement.getText().equals("Products")) {
            return true;
        }
        return false;
    }

    public boolean AppLogoVisible() {
        String appLogoText = "Swag Labs";
        WebElement webElement = waitUntilElementVisible(AppLogo);
        if (webElement.getText().equals(appLogoText)) {
            return true;
        }
        return false;
    }

    public boolean addToCart(String item) {
        String addToCartBtnText = "Add to cart";
        String removeBtnText = "Remove";
        WebElement webElement = waitUntilElementVisible(webDriver.findElement
                (By.id(StringUtil.generateAddToCardId(addToCartBtnText, item))));
        if (webElement.getText().equals(addToCartBtnText)) {
            clickButton(webElement);
            WebElement webElementRemove = waitUntilElementVisible(webDriver.findElement
                    (By.id(StringUtil.generateAddToCardId(removeBtnText, item))));
            if (webElementRemove.getText().equals(removeBtnText)) {
                return true;
            }
        }
        return false;
    }
}
