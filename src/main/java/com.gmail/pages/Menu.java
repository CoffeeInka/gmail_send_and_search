package com.gmail.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.gmail.core.ConciseAPI.$;

public class Menu {

    public static void refresh() {
        $(By.className("asf")).click();
    }

    public static void goToSent() {
        $(By.cssSelector("[title='Sent Mail']")).click();
    }
}
