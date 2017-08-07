package com.gmail;

import com.gmail.core.ConciseAPI;
import com.gmail.pages.Gmail;
import com.gmail.testdata.TestData;
import org.openqa.selenium.WebDriver;

public class GmailLogin extends ConciseAPI{

    public static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    Gmail gmail = new Gmail(getDriver());

    public void loginToGmail(){
        gmail.visit();
        gmail.login(TestData.mail, TestData.password);
    }

}
