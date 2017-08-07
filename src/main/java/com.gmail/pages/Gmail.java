package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.gmail.core.ConciseAPI.$;
import static com.gmail.core.ConciseAPI.setValue;

public class Gmail {

    public WebDriver driver;

    public Gmail(WebDriver driver) {
        this.driver = driver;
    }

    public void visit() {
        driver.get("http://gmail.com/");
    }

    public void login(String mail, String password) {
        setValue(driver, By.id("identifierId"), mail + Keys.ENTER);
        setValue(driver, By.name("password"), password + Keys.ENTER);
    }
}
