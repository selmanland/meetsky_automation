package com.cybertek.tests.zHomeWorks.HomeWork1;

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

public class HomeWorks1 {
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
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("wrong_dob");
        Thread.sleep(2000);

        String expectedResult = "The date of birth is not valid";
        WebElement actualResult = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));

        Assert.assertTrue(actualResult.isDisplayed(), "Verify that warning message is displayed");

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        WebElement element1 = driver.findElement(By.xpath("//div[@class='form-check form-check-inline'][1]"));
        WebElement element2 = driver.findElement(By.xpath("//div[@class='form-check form-check-inline'][2]"));
        WebElement element3 = driver.findElement(By.xpath("//div[@class='form-check form-check-inline'][3]"));

        Thread.sleep(3000);
        Assert.assertTrue(element1.isDisplayed(), "Verify that c++ is displayed");
        Assert.assertTrue(element2.isDisplayed(), "Verify that java is displayed");
        Assert.assertTrue(element3.isDisplayed(), "Verify that JavaScript is displayed");
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("firstname")).sendKeys("A");
        WebElement displatText = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));

        Thread.sleep(2000);
        Assert.assertTrue(displatText.isDisplayed(), "Verify that warning message is displayed");

    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("lastname")).sendKeys("A");
        WebElement displatText = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));

        Thread.sleep(2000);
        Assert.assertTrue(displatText.isDisplayed(), "Verify that warning message is displayed");

    }

    @Test
    public void test5() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("firstname")).sendKeys("Mike");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("Smith96");
        driver.findElement(By.name("email")).sendKeys("smith@cybertek.com");
        driver.findElement(By.name("password")).sendKeys("smith@cybertek.com");
        driver.findElement(By.name("phone")).sendKeys("571-256-355-562546");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/01/1984");

        WebElement department = driver.findElement(By.name("department"));

        Select select = new Select(department);
      //  List<WebElement> options = select.getOptions();
       // System.out.println("options.size() = " + options.size());
       // for (WebElement option : options) {
       //     System.out.println(option.getText());

       // }

        select.selectByVisibleText("Department of Engineering");
        String expectedResult = "Department of Engineering";
        String actualResult = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedResult,actualResult,"verify that they are the same");

        WebElement jobSelected = driver.findElement(By.name("job_title"));
        Select select1 = new Select(jobSelected);
        List<WebElement> options1 = select1.getOptions();

        for (WebElement jobs : options1) {

        }
        select1.selectByIndex(4);
        System.out.println(select.getFirstSelectedOption().getText());

        driver.findElement(By.xpath("//div[@class='form-check form-check-inline'][2]")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        String expectedFinish ="You've successfully completed registration!";
        String actualFinish = driver.findElement(By.xpath("//div[@class='alert alert-success']/p")).getText();

        Assert.assertEquals(expectedFinish,actualFinish,"verify that the texts are the same");


    }


}