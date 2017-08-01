package com.gmail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConciseAPI {

    //for way with elementLocator
    public static WebElement $(WebDriver driver, By elementLocator) {
        return assertThat(driver, visibilityOfElementLocated(elementLocator));
    }

    //for way with FindBy
    public static WebElement $(WebDriver driver, WebElement element) {
        return assertThat(driver, visibilityOf(element));

    }

    public static <V> V assertThat(WebDriver driver, ExpectedCondition<V> condition) {
        return new WebDriverWait(driver, 25).until(condition);
    }

    public static void setValue(WebDriver driver, By elementLocator, String text) {
        $(driver, elementLocator).clear();
        $(driver, elementLocator).sendKeys(text + Keys.ENTER);
    }

    public static By byText(String text) {
        return By.xpath(String.format("//*[text()='%s']", text));
    }
}
