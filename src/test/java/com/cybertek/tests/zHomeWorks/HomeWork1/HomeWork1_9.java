package com.cybertek.tests.zHomeWorks.HomeWork1;

import com.cybertek.utilities.WebDriverFactory;
import javafx.scene.control.TextInputDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class HomeWork1_9 {
       WebDriver driver;

      @BeforeMethod
     public void setUp() {
            driver = WebDriverFactory.getDriver("chrome");

       }

        @AfterMethod
    public void tearDown() throws InterruptedException {
            Thread.sleep(2000);
            //  driver.quit();

        }

        @Test
    public void test9(){
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            driver.findElement(By.linkText("Status Codes")).click();
            driver.findElement(By.linkText("200")).click();
            String expectedResult = "This page returned a 200 status code.";
            String text = driver.findElement(By.xpath("//p")).getText();
          //  System.out.println(text);
            String[] split = text.split("For a definition and common list of HTTP status codes, go here");
        //    System.out.println(Arrays.toString(split));
            String str =split[0];
            String actualResult = str.trim();
            System.out.println(actualResult);

          Assert.assertEquals(expectedResult,actualResult,"verify that exptectedResult equal actualResult");
        }


    @Test
    public void test10(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("301")).click();
        String expectedResult = "This page returned a 301 status code.";
        String text = driver.findElement(By.xpath("//p")).getText();
        //  System.out.println(text);
        String[] split = text.split("For a definition and common list of HTTP status codes, go here");
        //    System.out.println(Arrays.toString(split));
        String str =split[0];
        String actualResult = str.trim();
        System.out.println(actualResult);

        Assert.assertEquals(expectedResult,actualResult,"verify that exptectedResult equal actualResult");
    }
    @Test
    public void test11(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("404")).click();
        String expectedResult = "This page returned a 404 status code.";
        String text = driver.findElement(By.xpath("//p")).getText();
        System.out.println(text);
        String[] split = text.split("For a definition and common list of HTTP status codes, go here");
        System.out.println(Arrays.toString(split));
        String str =split[0];
        String actualResult = str.trim();
        System.out.println(actualResult);

        Assert.assertEquals(expectedResult,actualResult,"verify that exptectedResult equal actualResult");
    }

    @Test

    public void test12(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("500")).click();
        String expectedResult = "This page returned a 500 status code.";
        System.out.println("expectedResult.length() = " + expectedResult.length());
        String text = driver.findElement(By.xpath("//p")).getText();
        System.out.println(text);
        String actualResult = (text.substring(0, expectedResult.length())).trim();

        System.out.println("actualResult = " + actualResult);
        Assert.assertEquals(expectedResult,actualResult,"verify that exptectedResult equal actualResult");

    }


}
