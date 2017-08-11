package com.gmail.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CustomConditions {

    public static ExpectedCondition<WebElement> nthElementHasText(final By elementsListLocator, final int index, final String expectedText) {

        return elementExceptionsCatcher(new ExpectedCondition<WebElement>() {

            private WebElement element;
            private String elementText;
            private List<WebElement> elementsList;

            public WebElement apply(WebDriver driver) {
                elementsList = driver.findElements(elementsListLocator);
                element = elementsList.get(index);
                elementText = element.getText();
                return elementText.contains(expectedText) ? element : null;
            }

            public String toString() {
                return String.format("\nExpected text of element of list with locator %s \nby index %d\nshould contain: %s\nwhile actual text is: %s", elementsListLocator, index, expectedText, elementText);
            }
        });
    }


    public static ExpectedCondition<List<WebElement>> textsOf(final By elementsListlocator, final String... expectedTexts) {
        if (expectedTexts.length == 0) {
            throw new IllegalArgumentException("Array of expected texts is empty.");
        }
        return elementExceptionsCatcher(new ExpectedCondition<List<WebElement>>() {
            private List<String> actualTexts;
            private List<WebElement> elementsList;

            public List<WebElement> apply(WebDriver driver) {
                actualTexts = new ArrayList<>();
                elementsList = driver.findElements(elementsListlocator);
                for (WebElement element : elementsList) {
                    actualTexts.add(element.getText());
                }
                if (elementsList.size() != expectedTexts.length) {
                    return null;
                }
                for (int i = 0; i < expectedTexts.length; i++) {
                    if (!elementsList.get(i).getText().contains(expectedTexts[i])) {
                        return null;
                    }
                }
                return elementsList;
            }

            public String toString() {
                return String.format("\nFor list with locator %s\nexpected texts should contain: %s \nwhile actual texts are: %s", elementsListlocator, Arrays.asList(expectedTexts), actualTexts);
            }
        });
    }


    private static <V> ExpectedCondition<V> elementExceptionsCatcher(final ExpectedCondition<V> condition) {
        return new ExpectedCondition<V>() {
            public V apply(WebDriver input) {
                try {
                    return condition.apply(input);
                } catch (StaleElementReferenceException | ElementNotVisibleException | IndexOutOfBoundsException e) {
                    return null;
                }
            }

            public String toString() {
                return condition.toString();
            }
        };
    }


}
