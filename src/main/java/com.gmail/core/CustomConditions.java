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
                return expectedText.equals(elementText);
            }
            public String toString() {
                return String.format("\nexpected text by index %s\n to be: %s\n while actual text is: %s\n", index, expectedText, elementText);
            }
        };
    }


 public static ExpectedCondition<Boolean> textsOf(final List<WebElement> elementsList, final String... expectedTexts) {
        return new ExpectedCondition<Boolean>() {

            private WebElement element;
            private String elementText;

            public Boolean apply(WebDriver driver) {
                //gather texts of elements into list and operate just with list
                //via foreach
                //elementTexts.add(elementText);
                // if size and length are not equal, return false
                // if they are equal, check lists
                ArrayList<String> elementTexts = new ArrayList<String>();
                for(int i=0; i<elementsList.size(); i++){
                    element = elementsList.get(i);
                    elementText = element.getText();
                    elementText.contains(expectedTexts[i]);
                    //if doesn't contain return false;

                }
                    return true;
                }

            public String toString() {
                return String.format("\ntexts (\'%s\') to be present in elements %s", expectedTexts, elementsList);
                //"\nexpected text by index %s\n to be: %s\n while actual text is: %s\n", ...
                //to check when it works and when it doesn't
            }
        };
    }

}
