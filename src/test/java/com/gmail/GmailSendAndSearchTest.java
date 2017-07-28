package com.gmail;

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


public class GmailSendAndSearchTest {

    public static WebDriver driver;
    Gmail gmail = new Gmail(driver);
    Mails mails = new Mails(driver);
    Menu menu = new Menu(driver);

    @BeforeClass
    public static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette", false);
        driver = new FirefoxDriver(capabilities);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

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
        mails.assertMails(driver, subject);
    }
}
