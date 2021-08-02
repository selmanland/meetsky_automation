package com.cybertek.tests.myreviews;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class SelectionNoSelectionPopupsAndAlertsMW {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropElement = driver.findElement(By.id("state"));

        Select elements = new Select(dropElement);

        List<WebElement> options = elements.getOptions();
        for (WebElement each : options) {
            System.out.println(each.getText());
        }
        elements.selectByVisibleText("Alaska");
        String expectedOption = "Alaska";
        String actualOption = elements.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify that they match");

        System.out.println(options.get(5).getText());
    }
    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.findElement(By.id("dropdownMenuLink")).click();
        List<WebElement> elements = driver.findElements(By.className("dropdown-item"));

        System.out.println("elements.size() = " + elements.size());
        System.out.println(elements.get(2).getText());

    }
    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        String window1 = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windows : windowHandles) {
            if(!windows.equals(window1)){
                driver.switchTo().window(windows);
            }

        }
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

    }
}
