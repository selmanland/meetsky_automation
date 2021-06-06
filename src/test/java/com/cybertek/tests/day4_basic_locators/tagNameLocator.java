package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.tagName("input"));
        fullName.sendKeys("Mike Smith with tagname");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("mike@gmail.com");

        //lazy way to click
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
