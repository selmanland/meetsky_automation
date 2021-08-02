package com.cybertek.tests.zHomeWorks.HWVytrack;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.IAssertLifecycle;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HwVytrack extends TestBase {

    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        AllCalenderEvents allCalenderEvents = new AllCalenderEvents();
        allCalenderEvents.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(allCalenderEvents.elementOption,4);

        Assert.assertTrue(allCalenderEvents.elementOption.isDisplayed(), "verify that option is displayed");

    }

    @Test
    public void test2() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        AllCalenderEvents allCalenderEvents = new AllCalenderEvents();
        allCalenderEvents.waitUntilLoaderScreenDisappear();

        String expectedPageNumber = "1";
        String actualPageNumber = allCalenderEvents.numberPage.getAttribute("value");
        System.out.println(actualPageNumber);



    }

    @Test
    public void test3() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        AllCalenderEvents allCalenderEvents = new AllCalenderEvents();
        allCalenderEvents.waitUntilLoaderScreenDisappear();

        String extendedViewPerPage = "25";

        String actualViewPerPage = allCalenderEvents.viewPerPage.getText();
        System.out.println("actualViewPerPage = " + actualViewPerPage);

        Assert.assertEquals(actualViewPerPage,extendedViewPerPage,"verify view the page number");

    }

    @Test
    public void test4()  {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        AllCalenderEvents allCalenderEvents = new AllCalenderEvents();
        wait.until(ExpectedConditions.visibilityOf(allCalenderEvents.perPage25));

        allCalenderEvents.perPage25.click();

        allCalenderEvents.perPage100.click();
        allCalenderEvents.waitUntilLoaderScreenDisappear();

        System.out.println("allCalenderEvents.rows.size() = " + allCalenderEvents.rows.size());

        String numberOftTotalPage = allCalenderEvents.totalpage.getText();

        String[] numberOftTotalArray = numberOftTotalPage.split(" ");

        String totalPageString = numberOftTotalArray[1];

        int totalPageNumber = Integer.valueOf(totalPageString);

        int actualNumberOfRecords=0;
        for (int i =1; i <=totalPageNumber; i++) {

            actualNumberOfRecords+=allCalenderEvents.rows.size();
            allCalenderEvents.rightArrow.click();
            allCalenderEvents.waitUntilLoaderScreenDisappear();
            wait.until(ExpectedConditions.visibilityOf(allCalenderEvents.rightArrow));

        }
        System.out.println("actualNumberOfRecords = " + actualNumberOfRecords);

        String records = Driver.get().findElement(By.xpath("//label[contains(text(),'Total')]")).getText();
        String[] recordsArray = records.split(" ");
        int expectedRecords = Integer.valueOf(recordsArray[2]);
        System.out.println("expectedRecords = " + expectedRecords);

        Assert.assertEquals(actualNumberOfRecords,expectedRecords, "verify the number of records");


    }
    @Test
    public void test5() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        AllCalenderEvents allCalenderEvents = new AllCalenderEvents();
        allCalenderEvents.waitUntilLoaderScreenDisappear();

        wait.until(ExpectedConditions.visibilityOf(allCalenderEvents.perPage25));
        allCalenderEvents.perPage25.click();
        allCalenderEvents.perPage100.click();

        allCalenderEvents.selectAll.click();





        


    }

    @Test
    public void test6(){


        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        AllCalenderEvents allCalenderEvents = new AllCalenderEvents();
        allCalenderEvents.waitUntilLoaderScreenDisappear();

        allCalenderEvents.getEvent("Testers meeting","yes");

        Driver.get().findElement(By.xpath("//div[text()='Testers meeting']"));

        String text = Driver.get().findElement(By.xpath("//div[@class='section-content']/div")).getText();
        System.out.println(text);


    }

}