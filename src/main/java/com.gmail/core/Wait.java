package com.gmail.core;

import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by inna on 7/20/17.
 */
public class Wait {

        public static WebDriverWait wait;

        public Wait(WebDriverWait wait)
        {
            Wait.wait = wait;
        }
}
