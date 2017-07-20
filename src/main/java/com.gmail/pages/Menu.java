package com.gmail.pages;


import org.openqa.selenium.By;

import static com.gmail.core.Driver.driver;

/**
 * Created by inna on 6/26/17.
 */
public class Menu {

    public static void refresh() {
        driver.findElement(By.className("asf")).click();
    }

    public static void goToSent() {
        driver.findElement(By.cssSelector("[title='Sent Mail']")).click();
    }
}
