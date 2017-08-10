package com.gmail.core;


import org.openqa.selenium.WebDriver;

public class BasePage extends ConciseAPI {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
