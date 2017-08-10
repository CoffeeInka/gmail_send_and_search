package com.gmail.core;

import org.openqa.selenium.WebDriver;

/**
 * Created by inna on 10/08/2017.
 */
public class BasePage extends ConciseAPI{

    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
}
