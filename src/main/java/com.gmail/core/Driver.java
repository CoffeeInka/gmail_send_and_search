package com.gmail.core;

import org.openqa.selenium.WebDriver;

/**
 * Created by inna on 7/20/17.
 */
public class Driver {

        public static WebDriver driver;

        public Driver(WebDriver driver)
        {
            Driver.driver = driver;
        }
}
