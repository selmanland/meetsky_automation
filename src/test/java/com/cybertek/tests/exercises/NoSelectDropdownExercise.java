package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class NoSelectDropdownExercise {
    WebDriver driver;

    @BeforeMethod

        public void setUp(){
            driver= WebDriverFactory.getDriver("chrome");
        }

    @AfterMethod

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
     @Test
public void test() {
         driver.get("http://practice.cybertekschool.com/dropdown");

         WebElement dropLink = driver.findElement(By.id("dropdownMenuLink"));
         dropLink.click();

         List<WebElement> dropElements = driver.findElements(By.className("dropdown-item"));
         for (WebElement dropElement : dropElements) {
             System.out.println(dropElement.getText());
         }

     }
}