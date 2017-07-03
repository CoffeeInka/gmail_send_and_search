package com.gmail.pages;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by inna on 6/26/17.
 */
public class Menu {

    public static void refresh() {
        $(".asf").click();
    }

    public static void goToSent() {
        $("[title='Sent Mail']").click();
    }
}
