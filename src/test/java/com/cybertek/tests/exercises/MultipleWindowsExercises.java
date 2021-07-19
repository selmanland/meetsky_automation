package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsExercises {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.quit();
//    }

    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println(driver.getWindowHandle());
        // System.out.println("first=" + driver.getTitle());

        driver.findElement(By.linkText("Click Here"));

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(driver.getWindowHandle())) {
            }
            driver.switchTo().window(handle);
        }
        System.out.println(driver.getTitle());

    }

    @Test
    public void moreThan2Window() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String newWindow : windowHandles) {
            driver.switchTo().window(newWindow);

            if (driver.getTitle().equals("New Window")) {
                break;
            }

        }
        System.out.println(driver.getTitle());
    }
}