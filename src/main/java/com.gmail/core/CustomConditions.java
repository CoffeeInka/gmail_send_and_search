package com.gmail.core;

import org.openqa.selenium.By;
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


 public static ExpectedCondition<Boolean> textsOf(final List<WebElement> elementsList, final ArrayList<String> expectedTexts) {
        return new ExpectedCondition<Boolean>() {

            private WebElement element;
            private String elementText;

            public Boolean apply(WebDriver driver) {
                ArrayList<String> elementTexts = new ArrayList<String>();
                for(int i=0; i<elementsList.size(); i++){
                    element = elementsList.get(i);
                    elementText = element.getText();
                    elementTexts.add(i,elementText);}
                    return expectedTexts.equals(elementTexts);
                }

            public String toString() {
                return String.format("\ntexts (\'%s\') to be present in elements %s", expectedTexts, elementsList);
            }
        };
    }

}
