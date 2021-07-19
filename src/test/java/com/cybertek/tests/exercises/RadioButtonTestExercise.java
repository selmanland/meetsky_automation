package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTestExercise {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadio = driver.findElement(By.id("blue"));
        WebElement redRadio = driver.findElement(By.cssSelector("#red"));
        redRadio.click();
        System.out.println("redRadio.isSelected() = " + redRadio.isSelected());
        System.out.println("blueRadio.isSelected() = " + blueRadio.isSelected());

        Assert.assertTrue(redRadio.isSelected(),"verify that redRadio is selected");
        Assert.assertFalse(blueRadio.isSelected(),"verify that blueRadio is NOT selected");

        Thread.sleep(4000);
        driver.quit();

    }
}
