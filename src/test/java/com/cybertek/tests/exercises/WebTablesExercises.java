package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExercises {

    WebDriver driver;

    @BeforeMethod
    public void setUP() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("Tim"));

    }

    @Test
    public void getAllHeaders() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());

        }
    }

    @Test
    public void getRow() {
        WebElement rowElement = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(rowElement.getText());

        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i < numRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
            System.out.println(i + "-" + row.getText());

        }
    }
   @Test
    public void getAllCellInOneRow() {

        List<WebElement> elementsInRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));
            for (WebElement elements: elementsInRow) {
            System.out.println(elements.getText());

        }
       WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[2]"));
       System.out.println(element.getText());

   }

@Test
    public void printAllCellsByIndex() {
    int rowNumber = getNumbnerofRows();
    int colNumber = getNumberOfColumns();

    for (int i = 1; i < getNumbnerofRows(); i++) {

        for (int j = 1; j < getNumberOfColumns(); j++) {
            String cellXpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
            System.out.println(cellXpath);
            WebElement element = driver.findElement(By.xpath(cellXpath));
            System.out.println(element.getText());

        }


    }
}
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String firsName = "John";
        WebElement email = driver.findElement(By.xpath("//table[@id='table1']//td[text()='"+firsName+"']/../td[3]"));
        System.out.println(email.getText());
    }


    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
        return headers.size();


    }

    private int getNumbnerofRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return rows.size();
    }

}



