package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeExercise {

    WebDriver driver;
    @BeforeMethod
    public void setUp()  {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test(){
      driver.get("http://practice.cybertekschool.com/iframe");

      //driver.switchTo().frame("mce_0_ifr");
      driver.switchTo().frame(0);
      driver.findElement(By.id("tinymce")).clear();
      driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");

      //driver.switchTo().defaultContent();
      driver.switchTo().parentFrame();
      String text = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
      System.out.println(text);

        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith with web element");

    }
    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        driver.findElement(By.id("content"));
        driver.switchTo().parentFrame();
         //System.out.println(driver.findElement(By.name("frameset-middle")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));

    }












    }

