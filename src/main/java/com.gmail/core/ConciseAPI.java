package com.gmail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ConciseAPI {

    public static WebElement $(WebDriver driver, By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 6);
        return wait.until(visibilityOf(driver.findElement(elementLocator)));

    }

//    public static void assertThat(WebDriver driver, Boolean b) {
//        WebDriverWait wait = new WebDriverWait(driver, 6);
//        wait.until(b);
//    }
}
