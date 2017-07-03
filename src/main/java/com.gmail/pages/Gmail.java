package com.gmail.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by inna on 6/26/17.
 */
public class Gmail {

    public static void visit() {
        open("http://gmail.com/");
    }

    public static void login(String mail, String password) {
        $("#identifierId").setValue(mail).pressEnter();
        $(By.name("password")).setValue(password).pressEnter();
    }
}
