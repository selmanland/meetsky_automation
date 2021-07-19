package com.cybertek.tests.zHomeWorks.HomeWork1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorks1_6 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void test6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.id("email")).getText();
        System.out.println(email);
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("John");
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();

        String expectedResult ="Thank you for signing up. Click the button below to\n" +
                "return to the home page.";

        String actualResult = driver.findElement(By.xpath("//h1")).getText();

        Assert.assertNotEquals(expectedResult,actualResult,"verify that they are not equal");



    }


}
