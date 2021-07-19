package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButton {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueButton = driver.findElement(By.id("blue"));
        WebElement redButton = driver.findElement(By.id("red"));

        System.out.println("blueButton.isSelected() = " + blueButton.isSelected());
        System.out.println("redButton.isSelected() = " + redButton.isSelected());

        Assert.assertTrue(blueButton.isSelected(),"verify that blue is selected");
        Assert.assertFalse(redButton.isSelected(),"verify dat red button NOT selected");

        Thread.sleep(4000);
    }



}
