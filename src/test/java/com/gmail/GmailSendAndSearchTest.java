package com.gmail;

import com.gmail.pages.Gmail;
import com.gmail.pages.Mails;
import com.gmail.pages.Menu;
import com.gmail.core.Helpers;
import com.gmail.testdata.TestData;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.gmail.core.Driver.driver;
import static com.gmail.core.Wait.*;


/**
 * Created by inna on 08/06/2017.
 */
public class GmailSendAndSearchTest {

    @BeforeClass
    public static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette", false);
        driver = new FirefoxDriver(capabilities);
        wait = new WebDriverWait(driver, 25);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public static void gmailSendAndSearch() throws Exception {

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
