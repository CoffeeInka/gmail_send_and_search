package com.gmail.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.gmail.core.ConciseAPI.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CustomConditions {

    public static ExpectedCondition<WebElement> nthElementHasText(final List<WebElement> elementsList, final int index, final String expectedText) {

        return new ExpectedCondition<WebElement>() {

            private WebElement element;
            private String elementText;

            public WebElement apply(WebDriver driver) {
                element = assertThat(driver, visibilityOf(elementsList.get(index)));
                elementText = element.getText();
                return elementText.contains(expectedText)? element : null;
            }

            public String toString() {
                return String.format("\nExpected text of element of list %s by index %d should contain: %s while actual text is: %s", elementsList.get(index).getLocation(), index, expectedText, elementText);
            }
        };
    }


    public static ExpectedCondition <List<WebElement>> textsOf(final List<WebElement> elementsList, final String... expectedTexts) {
        if (expectedTexts.length == 0) {
            throw new IllegalArgumentException("Array of expected texts is empty.");
        }

        return new ExpectedCondition<List<WebElement>>() {

            private List<String> actualTexts;

            public List<WebElement> apply(WebDriver driver) {
                actualTexts = new ArrayList<String>();
                for (WebElement element : elementsList) {
                    actualTexts.add(element.getText());
                }
                if (actualTexts.size() != expectedTexts.length) {
                    return null;
                }
                for (int i = 0; i < actualTexts.size(); i++) {
                    if (!(actualTexts.get(i).contains(expectedTexts[i]))) {
                        return null;
                    }
                }
                return elementsList;
            }

            public String toString() {
                return String.format("\nExpected texts should contain: %s while actual texts are: %s", Arrays.asList(expectedTexts), actualTexts);
            }
        };
    }


}
