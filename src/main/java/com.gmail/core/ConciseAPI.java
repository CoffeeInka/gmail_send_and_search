package com.gmail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConciseAPI {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return ConciseAPI.driver;
    }

    public static void setDriver(WebDriver driver) {
        ConciseAPI.driver = driver;
    }

    public static WebElement $(By elementLocator) {
        return assertThat(visibilityOfElementLocated(elementLocator));
    }

    public static <V> V assertThat(ExpectedCondition<V> condition, long timeout) {
        return new WebDriverWait(getDriver(), timeout).until(condition);
    }

    public static <V> V assertThat(ExpectedCondition<V> condition) {
        return assertThat(condition, Configuration.timeout);
    }

    public static void setValue(By elementLocator, String text) {
        $(elementLocator).clear();
        $(elementLocator).sendKeys(text);
    }

    public static By byText(String text) {
        return By.xpath(String.format("//*[text()='%s']", text));
    }

    public static By byCss(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public static By by(String cssSelector) {
        return byCss(cssSelector);
    }

    public static void open(String url) {
        getDriver().get(url);
    }
}
