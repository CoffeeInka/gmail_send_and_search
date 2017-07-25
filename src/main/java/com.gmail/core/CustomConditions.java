package com.gmail.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.List;

public class CustomConditions {

    public static ExpectedCondition<Boolean> nthElementHasText(final List<WebElement> elementsList, final int index, final String expectedText) {
        return new ExpectedCondition<Boolean>() {

            private WebElement element;
            private String elementText;

            public Boolean apply(WebDriver driver) {
                element = elementsList.get(index);
                elementText = element.getText();
                return expectedText.contains(elementText);
            }

            public String toString() {
                return String.format("\nExpected text by index %s is: %s while actual text is: %s", index, expectedText, elementText);
            }
        };
    }


    public static ExpectedCondition<Boolean> textsOf(final List<WebElement> elementsList, final String... expectedTexts) {
        return new ExpectedCondition<Boolean>() {

            private String actualText;
            private String expectedText;
            List<String> actualTexts = new ArrayList<String>();
            List<String> expectedTextsList = new ArrayList<String>();

            public Boolean apply(WebDriver driver) {
                for (WebElement element : elementsList) {
                    actualText = element.getText();
                    actualTexts.add(actualText);
                }
                for (int i = 0; i < expectedTexts.length; i++) {
                    expectedText = expectedTexts[i];
                    expectedTextsList.add(expectedText);
                }

                if (!(actualTexts.size() == expectedTextsList.size())) {
                    return false;
                } else {
                    if (actualTexts.containsAll(expectedTextsList)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            public String toString() {
                return String.format("\nExpected texts are: %s while actual texts are: %s", expectedTextsList, actualTexts);
            }
        };
    }

}
