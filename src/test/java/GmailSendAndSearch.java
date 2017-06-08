import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

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
        $(By.name("password")).shouldBe(Condition.visible);
        $(By.name("password")).setValue(Config.password).pressEnter();

        $(byText("COMPOSE")).click();
        $("#:9k").setValue(Config.mail).pressTab();
        $("#:93").setValue("test").pressEnter();
        $(byText("Send")).click();

        $(".y6 b").$(byText("test")).shouldBe(Condition.visible);

        $(".J-Ke.n0.aBU").click();
        $(".y6 b").shouldHave(Condition.exactText("test"));

        $("#gs_taif50").setValue("subject:test").pressEnter();
        $$(".y6").shouldHave(CollectionCondition.size(1));

    }

}
