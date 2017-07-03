package com.gmail;

import com.codeborne.selenide.Configuration;
import com.gmail.pages.Gmail;
import com.gmail.pages.Mails;
import com.gmail.pages.Menu;
import com.gmail.core.Helpers;
import com.gmail.testdata.TestData;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Created by inna on 08/06/2017.
 */
public class GmailSendAndSearchTest {

    @BeforeClass
    public static void setup() {
        Configuration.timeout = 25000;
    }

    @Test
    public void gmailSendAndSearch() {

        Gmail.visit();

        Gmail.login(TestData.mail, TestData.password);

        String subject = Helpers.getUniqueString("Test");
        Mails.send(TestData.mail, subject);

        Menu.refresh();

        Mails.assertMail(0, subject);

        Menu.goToSent();
        Mails.assertMail(0, subject);

        Mails.searchInInboxBy(subject);
        Mails.assertMails(subject);
    }

}
