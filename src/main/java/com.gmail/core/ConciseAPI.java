package com.gmail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConciseAPI {

    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement $(By elementLocator) {
        return assertThat(visibilityOfElementLocated(elementLocator));
    }

    public <V> V assertThat(ExpectedCondition<V> condition, long timeout) {
        return new WebDriverWait(getDriver(), timeout).until(condition);
    }

    public <V> V assertThat(ExpectedCondition<V> condition) {
        return assertThat(condition, Configuration.timeout);
    }

    public void setValue(By elementLocator, String text) {
        $(elementLocator).clear();
        $(elementLocator).sendKeys(text);
    }

    public By byText(String text) {
        return By.xpath(String.format("//*[text()='%s']", text));
    }

    public By byCss(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public By by(String cssSelector) {
        return byCss(cssSelector);
    }

    public void open(String url) {
        getDriver().get(url);
    }
}
