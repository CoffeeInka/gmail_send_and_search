package com.gmail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class ConciseAPI {

    public abstract WebDriver getDriver();

    //for way with elementLocator
    public WebElement $(By elementLocator) {
        getDriver();
        return assertThat(visibilityOfElementLocated(elementLocator));
    }

    //for way with FindBy
    public WebElement $(WebElement element) {
        getDriver();
        return assertThat(visibilityOf(element));

    }

    public <V> V assertThat(ExpectedCondition<V> condition) {
        getDriver();
        return new WebDriverWait(getDriver(), 25).until(condition);
    }

    public void setValue(By elementLocator, String text) {
        $(elementLocator).clear();
        $(elementLocator).sendKeys(text);
    }

    public By byText(String text) {
        return By.xpath(String.format("//*[text()='%s']", text));
    }

    public By byCss (String cssSelector){
        return By.cssSelector(cssSelector);
    }

    public By by(String cssSelector){
        return byCss(cssSelector);
    }
}
