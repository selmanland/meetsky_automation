package com.cybertek.tests.zHomeWorks.HomeWork1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork1_7_8 {

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
    public void test7()  {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();
        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys("C:\\Users\\Administrator\\Desktop\\newfile.txt");
        driver.findElement(By.id("file-submit")).click();
        WebElement element = driver.findElement(By.id("uploaded-files"));

        Assert.assertTrue(element.isDisplayed(), "verify that new file is displayed");

    }

    @Test
    public void test8() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        WebElement result = driver.findElement(By.id("result"));
        System.out.println("result.isDisplayed() = " + result.isDisplayed());


    }
}