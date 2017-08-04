package com.gmail.pages;


import com.gmail.core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.gmail.core.ConciseAPI.$;

public class Menu extends ConciseAPI{

    public WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    public void refresh() {
        $(driver, By.className("asf")).click();
    }

    public void goToSent() {
        $(driver, By.cssSelector("[title='Sent Mail']")).click();
    }
}
