package com.cybertek.tests.exercises;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.zContactInfoPage;
import com.cybertek.pages.zContactsPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import javax.security.auth.login.Configuration;

public class verifyContactInfoTestExercise extends TestBase {
    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void test1() throws InterruptedException {
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Customers", "Contacts");

        String email ="mbrackstone9@example.com";

        zContactsPage zcontactsPage = new zContactsPage();

       // WebElement element = Driver.get().findElement(By.xpath("//td[contains(text(),'"+email+"')][@data-column-label='Email']"));
       // System.out.println(element.getText());
        zcontactsPage.waitUntilLoaderScreenDisappear();
        WebElement emailElement = zcontactsPage.getEmail(email);
        emailElement.click();


//        zContactInfoPage zcontactInfoPage =new zContactInfoPage();
//        String fullName ="Mariam Brackstone";
//        System.out.println(zcontactInfoPage.getName(fullName).getText());

    }
}