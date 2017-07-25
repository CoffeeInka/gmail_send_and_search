package com.gmail.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static com.gmail.core.ConciseAPI.$;
import static com.gmail.core.CustomConditions.nthElementHasText;
import static org.openqa.selenium.By.*;

public class Mails {

    public Mails(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(css = "[role=main] .zA")
    List<WebElement> mailList;

    public Mails(){
        PageFactory.initElements(driver, this);
    }

    public WebDriver driver;

    public void send(String mail, String subject) {
        //COMPOSE
        $(driver, xpath(".//*[@id=':7p']/div/div")).click();

        $(driver, cssSelector("[name='to']")).clear();
        $(driver, cssSelector("[name='to']")).sendKeys(mail);

        $(driver, cssSelector("[name='subjectbox']")).clear();
        $(driver, cssSelector("[name='subjectbox']")).sendKeys(subject + Keys.ENTER);

        //SEND
        $(driver, xpath(".//*[@id=':j6']")).click();
    }

    public void assertMail(int index, String text) {
        WebDriverWait wait = (new WebDriverWait(driver, 6));

        wait.until(nthElementHasText(mailList, index, text));
    }

    public void searchInInboxBy(String subject) {
        $(driver, cssSelector("[name='q']")).clear();
        $(driver, cssSelector("[name='q']")).sendKeys("in:inbox subject:" + subject);
        $(driver, cssSelector("[name='q']")).sendKeys(Keys.ENTER);
    }
}
