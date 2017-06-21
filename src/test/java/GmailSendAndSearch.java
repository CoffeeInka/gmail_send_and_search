import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by inna on 08/06/2017.
 */
public class GmailSendAndSearch {

    @BeforeClass
    public static void setup() {
        Configuration.browser = "firefox";
        Configuration.timeout=15000;
    }



    @Test
    public void gmailSendAndSearch() {
        open("http://gmail.com/");
        String jsCommand = "localStorage.clear()";
        executeJavaScript(jsCommand);
        refresh();
        $("#identifierId").setValue(Config.mail);
        $(".CwaK9").click();
        $("input[type='password']").setValue(Config.password).pressEnter();
        //$(".VBgE5b.W0PX5c.LM").shouldBe(visible);


        $(byText("COMPOSE")).is(visible);
        $(byText("COMPOSE")).click();
        $("[name='to']").shouldBe(visible);
        $("[name='to']").setValue(Config.mail).pressTab();
        $("[name='subjectbox']").setValue("test").pressEnter();
        $(byText("Send")).click();

        refresh();
        $(By.name("test")).shouldBe(visible);

        $("[title='Sent Mail']").click();
        $(".bog b").shouldHave(exactText("test"));

        $("[name='q']").setValue("subject:test").pressEnter();
        $$(".y6").filterBy(visible).shouldHave(CollectionCondition.size(1));

    }

}
