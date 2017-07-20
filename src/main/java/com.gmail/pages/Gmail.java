package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.gmail.core.Driver.driver;

/**
 * Created by inna on 6/26/17.
 */
public class Gmail {

    public static void visit() {
        driver.get("http://gmail.com/");
    }

    public static void login(String mail, String password) {
        driver.findElement(By.id("identifierId")).clear();
        driver.findElement(By.id("identifierId")).sendKeys(mail + Keys.ENTER);
        driver.findElement(By.cssSelector("password")).clear();
        driver.findElement(By.cssSelector("password")).sendKeys(password + Keys.ENTER);
    }
}
