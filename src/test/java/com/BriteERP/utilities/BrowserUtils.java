package com.BriteERP.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {

    public static WebDriver getDriver (String browser){
        if (browser.toLowerCase().equals("chrome")){
            WebDriverManager .chromedriver().setup();
            return new ChromeDriver();

        }else if (browser.toLowerCase().equals("firefox")){

            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            throw new IllegalArgumentException("Wrong browser name!");
        }
    }
}
