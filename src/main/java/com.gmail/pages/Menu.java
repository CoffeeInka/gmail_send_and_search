package com.gmail.pages;


import org.openqa.selenium.WebDriver;

import static com.gmail.core.ConciseAPI.$;
import static org.openqa.selenium.By.*;

public class Menu {

    public Menu(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver driver;

    public void refresh() {
        $(driver, className("asf")).click();
    }

    public void goToSent() {
        $(driver, cssSelector("[title='Sent Mail']")).click();
    }
}
