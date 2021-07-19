package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckDemotest {

    @Test

     public void test(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox = driver.findElement(By.name("checkbox2"));

        System.out.println(checkBox.isSelected());
        Assert.assertTrue(checkBox.isSelected(),"verify that it is selected");

        WebElement checkBox1 = driver.findElement(By.name("checkbox1"));
        checkBox1.click();
        checkBox.click();

        Assert.assertFalse(checkBox.isSelected(),"verify that is Not selected");
        Assert.assertTrue(checkBox1.isSelected(),"verify that it is selected");
    }



}
