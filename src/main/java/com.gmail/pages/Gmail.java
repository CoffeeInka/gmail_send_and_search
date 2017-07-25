package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.gmail.core.ConciseAPI.$;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class Gmail {

    public WebDriver driver;

    public Gmail(WebDriver driver){
        this.driver = driver;
    }

    public void visit() {
        driver.get("http://gmail.com/");
    }

    public void login(String mail, String password) {
        $(driver, By.id("identifierId")).clear();
        $(driver, By.id("identifierId")).sendKeys(mail + Keys.ENTER);
        $(driver, By.name("password")).clear();
        $(driver, By.name("password")).sendKeys(password + Keys.ENTER);
    }
}
