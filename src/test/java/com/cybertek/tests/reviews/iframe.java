package com.cybertek.tests.reviews;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iframe {

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
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        driver.switchTo().defaultContent();

         WebElement element = driver.findElement(By.name("frame-top"));
         driver.switchTo().frame(element);
         driver.switchTo().frame("frame-left");

    }

    @Test
    public void testImplcit() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.cssSelector("#finish"));

        driver.findElement(By.xpath("//div[@id='content'][1]"));

        //System.out.println(element.getText());

    }
    @Test
    public void testExplicit() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
        WebElement element = driver.findElement(By.xpath("//input[@type='text']"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys("hello");
    }

    @Test
    public void dragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);





    }





}
