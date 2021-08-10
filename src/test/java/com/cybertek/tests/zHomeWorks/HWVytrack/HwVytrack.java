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

import java.util.*;
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
        BrowserUtils.waitForVisibility(allCalenderEvents.elementOption, 4);

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
        extentLogger = report.createTest("Verify that per page number is 25");

        extentLogger.info("Login as a store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Navigate to Activities --> Calender Events");
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        AllCalenderEvents allCalenderEvents = new AllCalenderEvents();
        allCalenderEvents.waitUntilLoaderScreenDisappear();

        String extendedViewPerPage = "25";

        //verify that page view per page number 25
        String actualViewPerPage = allCalenderEvents.viewPerPage.getText();
        System.out.println("actualViewPerPage = " + actualViewPerPage);

        Assert.assertEquals(actualViewPerPage, extendedViewPerPage, "verify view the per page number");
        extentLogger.pass("Verify that view per page number is equal 25");
    }

    @Test
    public void test4() {
        extentLogger= report.createTest("Verify that number of calendar events (rows in the table) is equals to number of records");

        extentLogger.info("Login as a store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Navigate to Activities --> Calender Events");
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        AllCalenderEvents allCalenderEvents = new AllCalenderEvents();
        wait.until(ExpectedConditions.visibilityOf(allCalenderEvents.perPage25));

        //locate to view per page number "25" and click
        allCalenderEvents.perPage25.click();

        //arrange the view per page number as "100"

        allCalenderEvents.perPage100.click();
        allCalenderEvents.waitUntilLoaderScreenDisappear();

        //locate to all the tables and assign the list and find the number of row's size
        System.out.println("allCalenderEvents.rows.size() = " + allCalenderEvents.rows.size());

        //locate the total page of web page , get the text --> split the text --> assign array--> take the number as string
        String numberOftTotalPage = allCalenderEvents.totalpage.getText();
        String[] numberOftTotalArray = numberOftTotalPage.split(" ");

        String totalPageString = numberOftTotalArray[1];
        //convert to strint to integer
        int totalPageNumber = Integer.valueOf(totalPageString);

        int actualNumberOfRecords = 0;
        for (int i = 1; i <= totalPageNumber; i++) {

            actualNumberOfRecords += allCalenderEvents.rows.size();
            allCalenderEvents.rightArrow.click();
            allCalenderEvents.waitUntilLoaderScreenDisappear();
            wait.until(ExpectedConditions.visibilityOf(allCalenderEvents.rightArrow));

        }
        System.out.println("actualNumberOfRecords = " + actualNumberOfRecords);

        String records = Driver.get().findElement(By.xpath("//label[contains(text(),'Total')]")).getText();
        String[] recordsArray = records.split(" ");
        int expectedRecords = Integer.valueOf(recordsArray[2]);
        System.out.println("expectedRecords = " + expectedRecords);

        Assert.assertEquals(actualNumberOfRecords, expectedRecords, "verify the number of records");
        extentLogger.pass("Verify that total calendar events is equals to number of records");

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
        allCalenderEvents.waitUntilLoaderScreenDisappear();

        String numberOftTotalPage = allCalenderEvents.totalpage.getText();
        String[] numberOftTotalArray = numberOftTotalPage.split(" ");

        String totalPageString = numberOftTotalArray[1];
        int totalPageNumber = Integer.valueOf(totalPageString);
        System.out.println("totalPageNumber = " + totalPageNumber);

        for (int i = 1; i <= totalPageNumber; i++) {

            for (int j = 1; j < allCalenderEvents.rows.size(); j++) {

                Assert.assertTrue(allCalenderEvents.checkbox(j).isSelected(), "verify");

            }
            allCalenderEvents.rightArrow.click();
            allCalenderEvents.waitUntilLoaderScreenDisappear();
            wait.until(ExpectedConditions.visibilityOf(allCalenderEvents.rightArrow));
        }

    }

    @Test
    public void test6() {

        extentLogger = report.createTest("Verify that arranged meeting is displayed");

        //go to https://qa1.vytrack.com/
        extentLogger.info("Login as a store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Activities-->Calendar Events");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        AllCalenderEvents allCalenderEvents = new AllCalenderEvents();
        allCalenderEvents.waitUntilLoaderScreenDisappear();

        extentLogger.info("Select the arranged meeting");
        allCalenderEvents.getEvent("Testers meeting", "yes");

        Driver.get().findElement(By.xpath("//div[text()='Testers meeting']"));

        //assign the expected meeting details in the map
        Map<String, String> expectedMeeting = new LinkedHashMap<String, String>();
        expectedMeeting.put("Title", "Testers meeting");
        expectedMeeting.put("Description", "This is a a weekly testers meeting");
        expectedMeeting.put("Start", "Nov 27, 2019, 9:30 AM");
        expectedMeeting.put("End", "Nov 27, 2019, 10:30 AM");
        expectedMeeting.put("All-Day Event", "No");
        expectedMeeting.put("Organizer", "Stephan Haley");
        expectedMeeting.put("Guests", "Tom Smith - Required");
        expectedMeeting.put("Recurrence", "Weekly every 1 week on Wednesday");
        expectedMeeting.put("Call Via Hangout", "No");

        //assign the all the table keys to list
        List<WebElement> label1 = Driver.get().findElements(By.xpath("//label"));
        //assign the all the table values to list
        List<WebElement> label2 = Driver.get().findElements(By.xpath("//div[@class='controls']/div"));

        //create a map with actual meeting's keys and values
        Map<String, String> actualMeeting = new LinkedHashMap<String, String>();

        for (int i = 0; i < label1.size(); i++) {
            actualMeeting.put(label1.get(i).getText(), label2.get(i).getText());

        }
        extentLogger.info("Verify that expected meeting is arranged");
        Assert.assertTrue(actualMeeting.equals(expectedMeeting), "verify that meeting is ");

        extentLogger.pass("Verify that meeting details is displayed");

    }

}

