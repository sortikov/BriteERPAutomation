package com.BriteERP.tests;

import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifyTotalOfPivotTable {

    WebDriver driver = BrowserUtils.getDriver("chrome");

    @Test(description = "July 25 task")
    public void Test2() {
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


        Double total = Double.parseDouble(driver.findElement(By.xpath("//tr[1]/td[2]")).getText().replace(",",""));
        Double opportunityTotal = 0.00;
        List<Double> opportunityAmounts = new ArrayList<>();



        for (int i = 2; i <= 8; i++){
            opportunityAmounts.add(Double.parseDouble(driver.findElement(By.xpath("//tr["+i+"]/td[2]")).getText().replace(",","")));
        }

        for (Double opportunityAmnt: opportunityAmounts){

            opportunityTotal +=opportunityAmnt;

        }

        Assert.assertEquals(total,opportunityTotal);

        driver.close();
    }

}
