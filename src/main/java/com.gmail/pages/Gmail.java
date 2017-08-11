package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.gmail.core.ConciseAPI.*;

public class Gmail {

    public static void visit() {
        open("http://gmail.com/");
    }

    public static void login(String mail, String password) {
        setValue(By.id("identifierId"), mail + Keys.ENTER);
        setValue(By.name("password"), password + Keys.ENTER);
    }

}
