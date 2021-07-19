package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElementsExercises {
    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenButton = driver.findElement(By.id("green"));

        System.out.println("greenButton.isEnabled() = " + greenButton.isEnabled());

        Assert.assertFalse(greenButton.isEnabled(), "verify it is NOT enabled");

        WebElement redButton = driver.findElement(By.id("red"));

        System.out.println("redButton.isEnabled() = " + redButton.isEnabled());

        driver.quit();
    }
        @Test

        public void test2(){

         WebDriver driver = WebDriverFactory.getDriver("chrome");

         driver.manage().window().maximize();
         driver.get("http://practice.cybertekschool.com/dynamic_controls");

         WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

         inputBox.sendKeys("hello world");












    }
}
