package com.gmail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by inna on 7/20/17.
 */
public class CustomConditions {

    public static ExpectedCondition<Boolean> textsToBePresentInElementsLocated(final By elementsLocator, final expectedTexts) {
        return new ExpectedCondition<Boolean>() {

            private List<String> expectedTexts;
            private List<WebElement> elements;

            public Boolean apply(WebDriver driver) {
                elements = driver.findElements(elementsLocator);
                for (element: elementsLocator
                     ) { driver.findElement(By.cssSelector(elementsLocator)).getText();
                    return Boolean.valueOf(elements.contains(expectedTexts));
                }

                }
            };}

            public String toString() {
                return String.format("texts (\'%s\') to be present in elements found by %s", new Object[]{expectedTexts, elementsLocator});
            }
        };
    }
}
