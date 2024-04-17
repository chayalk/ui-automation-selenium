package com.saucedemo.addToCart;

import com.saucedemo.TestBase;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddCart extends TestBase {

    @Test(alwaysRun = true, description = "Test case:3 Verify add item to cart")
    public void TestProductPage() {
        String userName = "standard_user";
        String password = "secret_sauce";
        String itemName = "Sauce Labs Bike Light";

        HomePage homePage = new HomePage();
        ProductsPage productsPage = new ProductsPage();
        homePage.login(userName, password);

        if (productsPage.AppLogoVisible()) {
            Assert.assertTrue(productsPage.addToCart(itemName));
        }
    }
}
