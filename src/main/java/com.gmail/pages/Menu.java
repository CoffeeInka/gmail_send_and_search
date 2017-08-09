package com.gmail.pages;


import com.gmail.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu extends BasePage {

    public Menu(WebDriver driver) {
        super(driver);
    }

    public void refresh() {
        $(By.className("asf")).click();
    }

    public void goToSent() {
        $(By.cssSelector("[title='Sent Mail']")).click();
    }
}
