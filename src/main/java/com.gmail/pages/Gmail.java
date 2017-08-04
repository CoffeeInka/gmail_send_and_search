package com.gmail.pages;

import com.gmail.core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Gmail extends ConciseAPI{

    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    public Gmail(WebDriver driver) {
        this.driver = driver;
    }

    public void visit() {
        driver.get("http://gmail.com/");
    }

    public void login(String mail, String password) {
        setValue(By.id("identifierId"), mail + Keys.ENTER);
        setValue(By.name("password"), password  + Keys.ENTER);
    }

}
