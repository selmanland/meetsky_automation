package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemoExercises {
    @Test
    public void test1() throws InterruptedException {
      WebDriver driver = WebDriverFactory.getDriver("chrome");
      driver.get("http://practice.cybertekschool.com/dynamic_loading/1");


         WebElement username = driver.findElement(By.id("username"));
        System.out.println("username.isDisplayed() = " + username.isDisplayed());
        Assert.assertFalse(username.isDisplayed(),"verify it is NOT displayed");

        driver.findElement(By.xpath("//button[text()='Start']")).click();
        Thread.sleep(7000);

        Assert.assertTrue(username.isDisplayed(),"verify that it is displayed");


    }
}