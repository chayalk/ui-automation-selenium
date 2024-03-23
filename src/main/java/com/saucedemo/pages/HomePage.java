package com.saucedemo.pages;

import com.saucedemo.framework.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {

    public HomePage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "user-name")
    WebElement txtFieldUserName;

    @FindBy(id = "password")
    WebElement txtFieldPassword;

    @FindBy(id = "login-button")
    WebElement btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement loginFailErrorMsg;

    public void login(String userName, String password) {
        inputText(userName, txtFieldUserName);
        inputText(password, txtFieldPassword);
        clickButton(btnLogin);
    }

    public String loginFailValidationMsg() {
        return getWebElementText(loginFailErrorMsg);
    }

}
