package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitExplicitWaitExercise {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
}

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

   @Test
    public void test() throws InterruptedException {
    driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
       WebElement element = driver.findElement(By.xpath("//h4[contains(text(),'Hello World')]"));
       System.out.println(element.getText());

   }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.tagName("button")).click();
        WebElement usernameInput = driver.findElement(By.id("username"));

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        

    }





}
