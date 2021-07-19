package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTestExercise {

    WebDriver driver;

   @BeforeMethod
   public void setUp(){
       driver = WebDriverFactory.getDriver("chrome");

   }
    @AfterMethod
    public void tearDown() throws InterruptedException {
       Thread.sleep(2000);
       driver.quit();

    }

   @Test
   public void test1(){
       driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropElement = driver.findElement(By.id("state"));
        Select selectOptions = new Select(dropElement);


       List<WebElement> options = selectOptions.getOptions();
       System.out.println(options.size());
       for (WebElement option : options) {
           System.out.println(option.getText().length());
       }
       System.out.println(options.get(4).getText());
   }

    @Test

    public void test2(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropElement = driver.findElement(By.id("state"));
        Select selectElements = new Select(dropElement);

        selectElements.selectByIndex(1);
        System.out.println(selectElements.getFirstSelectedOption());

        for(int i=0; i<53; i++){

            selectElements.selectByIndex(i);
            System.out.println(selectElements.getFirstSelectedOption().getText());

        }

        selectElements.selectByValue("AL");
        System.out.println(selectElements.getFirstSelectedOption().getText());




    }









}
