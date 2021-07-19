package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Attribute {

@Test
   public void test1(){
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.get("http://practice.cybertekschool.com/radio_buttons");

    WebElement blueRadio = driver.findElement(By.xpath("//label[text()='Blue']/preceding-sibling::input"));
    System.out.println("blueRadio.getAttribute(\"value\") = " + blueRadio.getAttribute("value"));//on

 System.out.println("blueRadio.getAttribute(\"type\") = " + blueRadio.getAttribute("type"));
 System.out.println(blueRadio.getAttribute("checked"));

 System.out.println("blueRadio.getAttribute(\"outerHTML\") = " + blueRadio.getAttribute("outerHTML"));

 driver.get("http://practice.cybertekschool.com/multiple_buttons");

 WebElement button2= driver.findElement(By.cssSelector("[onclick='button2()']"));
 String outerHTML = button2.getAttribute("outerHTML");
 System.out.println("button2.getAttribute(\"innerHTML\") = " + button2.getAttribute("innerHTML"));
 Assert.assertTrue(outerHTML.contains("Button 2"),"verify it is available");

}

}
