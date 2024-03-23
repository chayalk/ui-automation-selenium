package com.saucedemo.login;

import com.saucedemo.TestBase;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {

    @Test(alwaysRun = true, description = "Test case:1 Verify login with valid credentials")
    public void testLoginWithValidCredentials() {
        String userName = "standard_user";
        String password = "secret_sauce";

        HomePage homePage = new HomePage();
        ProductsPage productsPage = new ProductsPage();
        homePage.login(userName, password);

        Assert.assertTrue(productsPage.productPageVisible());
    }

    @Test(alwaysRun = true, description = "Test case:2 Verify login failure message with invalid credentials")
    public void testLoginWithInvalidCredentials() {
        String expectedValidationMessage = "Epic sadface: Username and password do not match any user in this service";

        HomePage homePage = new HomePage();
        ProductsPage productsPage = new ProductsPage();
        homePage.login("invalid", "invalid");

        Assert.assertEquals(homePage.loginFailValidationMsg(), expectedValidationMessage);
    }
}
