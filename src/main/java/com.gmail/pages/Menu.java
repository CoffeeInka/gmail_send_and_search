package com.gmail.pages;


import com.gmail.core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu extends ConciseAPI {

    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    public void refresh() {
        $(By.className("asf")).click();
    }

    public void goToSent() {
        $(By.cssSelector("[title='Sent Mail']")).click();
    }
}
