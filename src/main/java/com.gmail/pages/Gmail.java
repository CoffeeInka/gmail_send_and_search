package com.gmail.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.gmail.core.ConciseAPI.$;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class Gmail {

    public WebDriver driver;

    public void visit() {
        driver.get("http://gmail.com/");
    }

    public void login(String mail, String password) {
        $(driver, id("identifierId")).clear();
        $(driver, id("identifierId")).sendKeys(mail + Keys.ENTER);
        $(driver, cssSelector("password")).clear();
        $(driver, cssSelector("password")).sendKeys(password + Keys.ENTER);
    }
}
