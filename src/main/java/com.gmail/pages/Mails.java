package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.gmail.core.ConciseAPI.*;
import static com.gmail.core.CustomConditions.nthElementHasText;
import static com.gmail.core.CustomConditions.textsOf;

public class Mails {

    public WebDriver driver;

    public Mails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[role=main] .zA")
    List<WebElement> mailList;

    public void send(String mail, String subject) {
        $(driver, byText("COMPOSE")).click();

        //$(driver, By.cssSelector("[id=':ar']")).click();
        //$(driver, By.name("to")).sendKeys(mail);
        $(driver, byText("Recipients")).click();
        $(driver, By.name("to")).sendKeys(mail);
        setValue(driver, By.name("subjectbox"), subject);

        $(driver, byText("Send")).click();
    }

    public void assertMail(int index, String text) {
        assertThat(driver, nthElementHasText(mailList, index, text));
    }

    public void searchInInboxBy(String subject) {
        setValue(driver, By.name("q"), "in:inbox subject:" + subject);
    }

    public void assertMails(String... texts) {
        assertThat(driver, textsOf(mailList, texts));
    }
}
