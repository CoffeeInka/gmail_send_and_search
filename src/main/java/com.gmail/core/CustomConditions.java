package com.gmail.core;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CustomConditions {

    public static ExpectedCondition<WebElement> nthElementHasText(final List<WebElement> elementsList, final int index, final String expectedText) {

        return elementExceptionsCatcher(new ExpectedCondition<WebElement>() {

            private WebElement element;
            private String elementText;

            public WebElement apply(WebDriver driver) {
                element = elementsList.get(index);
                elementText = element.getText();
                return elementText.contains(expectedText) ? element : null;
            }

            public String toString() {
                return String.format("\nExpected text of element of list %s by index %d should contain: %s while actual text is: %s", elementsList.get(index).toString(), index, expectedText, elementText);
            }
        });
    }

// Implemented without catcher
//
//    public static ExpectedCondition <List<WebElement>> textsOf(final List<WebElement> elementsList, final String... expectedTexts) {
//        if (expectedTexts.length == 0) {
//            throw new IllegalArgumentException("Array of expected texts is empty.");
//        }
//
//        return new ExpectedCondition<List<WebElement>>() {
//
//            private List<String> actualTexts;
//
//            public List<WebElement> apply(WebDriver driver) {
//                actualTexts = new ArrayList<String>();
//                for (WebElement element : elementsList) {
//                    actualTexts.add(element.getText());
//                }
//                if (actualTexts.size() != expectedTexts.length) {
//                    return null;
//                }
//                for (int i = 0; i < actualTexts.size(); i++) {
//                    if (!(actualTexts.get(i).contains(expectedTexts[i]))) {
//                        return null;
//                    }
//                }
//                return elementsList;
//            }
//
//            public String toString() {
//                return String.format("\nExpected texts should contain: %s while actual texts are: %s", Arrays.asList(expectedTexts), actualTexts);
//            }
//        };
//    }

    public static ExpectedCondition<List<WebElement>> textsOf(final List<WebElement> elementsList, final String... expectedTexts) {
        if (expectedTexts.length == 0) {
            throw new IllegalArgumentException("Array of expected texts is empty.");
        }
        return elementExceptionsCatcher(new ExpectedCondition<List<WebElement>>() {
            public List<String> actualTexts;

            public List<WebElement> apply(WebDriver driver) {
                actualTexts = new ArrayList<String>();
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
                return String.format("\nExpected texts should contain: %s while actual texts are: %s", Arrays.asList(expectedTexts), actualTexts);
            }
        });
    }


    public static <V> ExpectedCondition<V> elementExceptionsCatcher(final ExpectedCondition<V> condition) {
        return new ExpectedCondition<V>() {
            public V apply(WebDriver input) {
                try {
                    return condition.apply(input);
                } catch (StaleElementReferenceException e) {
                    return null;
                } catch (ElementNotVisibleException e) {
                    return null;
                }
            }

            public String toString() {
                return condition.toString();
            }
        };
    }


}
