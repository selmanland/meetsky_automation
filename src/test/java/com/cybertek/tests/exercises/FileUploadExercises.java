package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadExercises {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }


    @Test
    public void test1(){

        System.out.println(System.getProperty("os.name"));
        String path = System.getProperty("user.dir");
        System.out.println(path);
        String filepath = "src/test/resources/textfile2.txt";
        String fullpath = path+"/"+filepath;

    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");
        String property = System.getProperty("user.dir");
        String filepath = "src/test/resources/textfile2.txt";
        String fullpath = property +"/"+ filepath;

        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys(fullpath);
         driver.findElement(By.id("file-submit")).click();


    }
}
