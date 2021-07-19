package com.cybertek.tests.exercises;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
public class ListOfElementsExercises {
    WebDriver driver;

    @BeforeMethod
    public void setUP(){
        driver= WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

@Test
public void test1() {
    driver.get("http://practice.cybertekschool.com/multiple_buttons");
    List<WebElement> buttons = driver.findElements(By.tagName("button"));
    System.out.println("buttons.size() = " + buttons.size());

    for (WebElement button : buttons) {
        System.out.println(button.getText());
        Assert.assertTrue(button.isDisplayed(), "verify");

    }
    System.out.println("buttons.get(3).getText() = " + buttons.get(3).getText().length());

}





}