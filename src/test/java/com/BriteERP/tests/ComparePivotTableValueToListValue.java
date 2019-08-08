package com.BriteERP.tests;

import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ComparePivotTableValueToListValue {


    WebDriver driver = BrowserUtils.getDriver("chrome");


    @Test(description = "July 25 task")
    public void Test1() {
        driver.get("http://34.220.250.213/web/login");

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#login")).sendKeys("salesmanager65@info.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("salesmanager");

        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SeleniumUtils.waitPlease(5);

        driver.findElement(By.xpath("//span[contains(text(),'CRM')]")).click();
        SeleniumUtils.waitPlease(5);

        driver.findElement(By.cssSelector("button[class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']")).click();
        SeleniumUtils.waitPlease(5);


        driver.findElement(By.xpath("//tr/td")).click();
        SeleniumUtils.waitPlease(5);

        driver.findElement(By.xpath("//tr/td")).click();
        SeleniumUtils.waitPlease(5);

        driver.findElement(By.xpath("//a[contains(text(),'Opportunity')]")).click();
        SeleniumUtils.waitPlease(5);


        String pivotValue = driver.findElement(By.xpath("//td[contains(text(),'Samarqand Non')]/following-sibling::td")).getText();

        driver.findElement(By.cssSelector("button[class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']")).click();
        SeleniumUtils.waitPlease(5);

        String listValue = driver.findElement(By.xpath("//td[contains(text(),'Samarqand Non')]/following-sibling::td[6]")).getText();


        Assert.assertEquals(pivotValue, listValue);

        SeleniumUtils.waitPlease(5);

        driver.close();
    }
}
