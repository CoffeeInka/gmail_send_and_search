package com.gmail.pages;

import com.gmail.core.ConciseAPI;
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

public class Mails extends BasePage{

    public Mails(WebDriver driver) {
      super(driver);
    }

    @FindBy(css = "[role=main] .zA")
    List<WebElement> mailList;

    public void send(String mail, String subject) {
        $(byText("COMPOSE")).click();

        //$(driver, By.cssSelector("[id=':ar']")).click();
        //$(driver, By.name("to")).sendKeys(mail);
        $(byText("Recipients")).click();
        //$(driver, By.name("to")).sendKeys(mail);
        setValue(By.name("to"), mail);
        setValue(By.name("subjectbox"), subject + Keys.ENTER);

        $(byText("Send")).click();
    }

    public void assertMail(int index, String text) {
        assertThat(nthElementHasText(mailList, index, text));
    }

    public void searchInInboxBy(String subject) {
        setValue(By.name("q"), "in:inbox subject:" + subject + Keys.ENTER);
    }

    public void assertMails(String... texts) {
        assertThat(textsOf(mailList, texts));
    }
}
