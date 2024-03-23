package com.saucedemo;

import com.saucedemo.framework.DriverSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    private DriverSetup driverSetup;

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        driverSetup.quitDriver();
    }

    @BeforeClass(alwaysRun = true)
    public void initialise() {
        driverSetup = DriverSetup.getWebDriverManagerInstance();
        DriverSetup.getWebDriverManagerInstance().startDriver();
        driverSetup.navigateToHomePage();
    }
}
