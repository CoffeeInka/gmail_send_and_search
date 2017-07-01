package com.gmail.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by inna on 6/26/17.
 */
public class Mails {

    public static ElementsCollection mailList = $$("[role=main] .zA");

    public static void send(String mail, String subject) {
        $(byText("COMPOSE")).click();
        $("[name='to']").setValue(mail);
        $("[name='subjectbox']").setValue(subject).pressEnter();
        $(byText("Send")).click();
    }

    public static void assertMail(int index, String text) {
        mailList.get(index).shouldHave(text(text));
    }

    public static void searchInInboxBy(String text) {
        $("[name='q']").setValue("in:inbox subject:" + text).pressEnter();
    }

    public static void assertMails(String text) {
        mailList.shouldHave(texts(text));
    }
}
