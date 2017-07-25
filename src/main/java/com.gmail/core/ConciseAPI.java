package com.gmail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConciseAPI {

    //for way with elementLocator
    public static WebElement $(WebDriver driver, By elementLocator) {
    //  return new WebDriverWait(driver, 10).until(visibilityOfElementLocated(elementLocator));
        assertThat(driver, visibilityOfElementLocated(elementLocator));
        return driver.findElement(elementLocator);
    }

    //for way with FindBy
    public static WebElement $(WebDriver driver, WebElement element) {
    //  return new WebDriverWait(driver, 10).until(visibilityOf(element));
        assertThat(driver, visibilityOf(element));
        return element;
    }

    public static void assertThat(WebDriver driver, ExpectedCondition condition) {
        new WebDriverWait(driver, 25).until(condition);
    }
}
