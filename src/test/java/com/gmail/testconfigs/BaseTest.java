package com.gmail.testconfigs;

import com.gmail.core.ConciseAPI;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest extends ConciseAPI {

    @BeforeClass
    public static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette", false);
        driver = new FirefoxDriver(capabilities);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }

    public static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }


}
