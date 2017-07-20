package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.gmail.core.CustomConditions.textsToBePresentInElementsLocated;
import static com.gmail.core.Driver.driver;
import static com.gmail.core.Wait.wait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by inna on 6/26/17.
 */
public class Mails {

    @FindBy(css = "[role=main] .zA")
    List<WebElement> mailList;

    Mails mails = PageFactory.initElements(driver, Mails.class);

    public static void send(String mail, String subject) {
        driver.findElement(By.name("COMPOSE")).click();

        driver.findElement(By.cssSelector("[name='to']")).clear();
        driver.findElement(By.cssSelector("[name='to']")).sendKeys(mail);

        driver.findElement(By.cssSelector("[name='subjectbox']")).clear();
        driver.findElement(By.cssSelector("[name='subjectbox']")).sendKeys(subject + Keys.ENTER);

        driver.findElement(By.name("Send")).click();
    }

    public static void assertMail(int index, String text) {
        wait.until(textToBePresentInElementLocated(By.cssSelector(mailList).get(index)), text);
    }

    public static void searchInInboxBy(String subject) {
        driver.findElement(By.cssSelector("[name='q']")).clear();
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("in:inbox subject:" + subject);
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);
    }

    public static void assertMails(String... text) {
        wait.until(textsToBePresentInElementsLocated(By.cssSelector(mailList)), text);
    }
}
