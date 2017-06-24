import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Calendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
        String subject = currentSubject();
        $("[name='subjectbox']").setValue(subject).pressEnter();
        $(byText("Send")).click();

        $(".asf.T-I-J3.J-J5-Ji").click();

        ElementsCollection mailList = $$("[role=main] .zA");
        mailList.first().shouldHave(text(subject));

        $("[title='Sent Mail']").click();
        mailList.first().shouldHave(text(subject));

        $("[name='q']").setValue("in:inbox subject:"+subject).pressEnter();
        mailList.shouldHave(CollectionCondition.texts(subject));
    }

    public static String currentSubject() {
        Calendar cal = Calendar.getInstance();
        return String.format("Test %tF %<tT.%<tL", cal, cal);
    }
}
