package com.gmail.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
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
                return String.format("\nExpected text by index %s to be: %s while actual text is: %s", index, expectedText, elementText);
            }
        };
    }


    public static ExpectedCondition<Boolean> textsOf(final List<WebElement> elementsList, final String... expectedTexts) {
        return new ExpectedCondition<Boolean>() {

            private List<String> actualTexts;
            private List<String> expectedTextsList = Arrays.asList(expectedTexts);

            public Boolean apply(WebDriver driver) {
                actualTexts = new ArrayList<String>();
                for (WebElement element : elementsList) {
                    actualTexts.add(element.getText());
                }
                if (actualTexts.size() != expectedTexts.length) {
                    return false;
                }
                for (int i = 0; i < actualTexts.size(); i++) {
                    if (!(actualTexts.get(i).contentEquals(expectedTexts[i]))) {
                        return false;
                    }
                }
                return true;
            }

            public String toString() {
                return String.format("\nExpected texts to be: %s while actual texts are: %s", expectedTextsList, actualTexts);
            }
        };
    }

}
