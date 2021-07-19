package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlertsExercises {

   WebDriver driver;

   @BeforeMethod
    public void setUp() throws InterruptedException {

       driver = WebDriverFactory.getDriver("chrome");
   }
       @AfterMethod

     public void tearDown() throws InterruptedException {
       Thread.sleep(5000);
       driver.quit();
       }

    @Test

    public void test1(){
  driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

  driver.findElement(By.xpath("(//span[text()='Confirm'])[1]")).click();
  driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

    }
@Test
    public void test2() throws InterruptedException {
     driver.get("http://practice.cybertekschool.com/javascript_alerts");
    driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
     Alert alert = driver.switchTo().alert();

    Thread.sleep(2000);
    alert.accept();

    driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
    Thread.sleep(2000);
    alert.sendKeys("hello");
    Thread.sleep(2000);
    alert.dismiss();
}








   }

