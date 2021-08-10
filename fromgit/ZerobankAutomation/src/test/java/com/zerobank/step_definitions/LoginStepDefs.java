package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
       // Assert.assertEquals("verify the user is on the login page", "http://zero.webappsecurity.com/login.html", Driver.get().getCurrentUrl());
    }

    @When("the user enters credentials")
    public void the_user_enters_credentials() {

        String username = ConfigurationReader.get("authorized_username");
        String password = ConfigurationReader.get("authorized_password");

        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);
        BrowserUtils.waitFor(3);


    }

    @Then("the account summary page should be displayed")
    public void the_account_summary_page_should_be_displayed() {

        Assert.assertTrue("verify the account summary page is displayed", Driver.get().getTitle().contains("Account Summary"));
    }

    @When("the user enters invalid credentials {string} {string}")
    public void the_user_enters_invalid_credentials(String username, String password) {

        String User = ConfigurationReader.get("username");
        String Pass = ConfigurationReader.get("password");

        if (!User.equals(username) || !Pass.equals(password)) {
            new LoginPage().login(username, password);
        }

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        Assert.assertTrue("verify the error message is displayed", new LoginPage().errorMessage.isDisplayed());
        System.err.println("Login and/or password are wrong.");
    }
}