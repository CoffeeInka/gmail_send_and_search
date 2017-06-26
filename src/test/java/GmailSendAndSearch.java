import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Calendar;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by inna on 08/06/2017.
 */
public class GmailSendAndSearch {

    @BeforeClass
    public static void setup() {
        Configuration.timeout = 25000;
    }


    @Test
    public void gmailSendAndSearch() {
        open("http://gmail.com/");
        $("#identifierId").setValue(Config.mail).pressEnter();
        $(By.name("password")).setValue(Config.password).pressEnter();

        $(byText("COMPOSE")).click();
        $("[name='to']").setValue(Config.mail);
        String subject = getUniqueString("Test");
        $("[name='subjectbox']").setValue(subject).pressEnter();
        $(byText("Send")).click();

        refresh();
        assertMail(0, subject);

        $("[title='Sent Mail']").click();
        assertMail(0, subject);

        $("[name='q']").setValue("in:inbox subject:" + subject).pressEnter();
        mailList.shouldHave(texts(subject));
    }

    private void assertMail(int index, String text){
        mailList.get(index).shouldHave(text(text));
    }

    ElementsCollection mailList = $$("[role=main] .zA");

    private void refresh() {
        $(".asf").click();
    }

}
