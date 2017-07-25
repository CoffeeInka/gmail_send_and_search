package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.gmail.core.ConciseAPI.$;

public class Gmail {

    public WebDriver driver;

    public Gmail(WebDriver driver){
        this.driver = driver;
    }

    public void visit() {
        driver.get("http://gmail.com/");
        driver.manage().window().maximize();
    }

    public void login(String mail, String password) {
        $(driver, By.id("identifierId")).clear();
        $(driver, By.id("identifierId")).sendKeys(mail + Keys.ENTER);
        $(driver, By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).clear();
        $(driver, By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(password + Keys.ENTER);
    }
}
