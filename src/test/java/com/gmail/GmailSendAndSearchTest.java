package com.gmail;

import com.gmail.core.ConciseAPI;
import com.gmail.core.Helpers;
import com.gmail.pages.Gmail;
import com.gmail.pages.Mails;
import com.gmail.pages.Menu;
import com.gmail.testdata.TestData;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class GmailSendAndSearchTest extends GmailLogin {

    private Mails mails = new Mails(getDriver());
    private Menu menu = new Menu(getDriver());
    Gmail gmail = new Gmail(getDriver());

    @Test
    public void gmailSendAndSearch() {

        gmail.visit();
        gmail.login(TestData.mail, TestData.password);

        String subject = Helpers.getUniqueString("Test");
        mails.send(TestData.mail, subject);

        menu.refresh();

        mails.assertMail(0, subject);

        menu.goToSent();
        mails.assertMail(0, subject);

        mails.searchInInboxBy(subject);
        mails.assertMails(subject);
    }

}
