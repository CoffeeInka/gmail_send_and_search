package com.gmail;

import com.gmail.pages.Gmail;
import com.gmail.pages.Mails;
import com.gmail.pages.Menu;
import com.gmail.core.Helpers;
import com.gmail.testdata.TestData;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.gmail.core.ConciseAPI.assertThat;
import static com.gmail.core.CustomConditions.textsOf;

public class GmailSendAndSearchTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

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

        Gmail gmail = new Gmail();
        Mails mails = new Mails();
        Menu menu = new Menu();

        gmail.visit();
        gmail.login(TestData.mail, TestData.password);

        String subject = Helpers.getUniqueString("Test");
        mails.send(TestData.mail, subject);

        menu.refresh();

        mails.assertMail(0, subject);

        menu.goToSent();
        mails.assertMail(0, subject);

        mails.searchInInboxBy(subject);
        assertThat(driver, textsOf(mailList, texts));
    }
}
