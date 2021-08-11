
package com.meetsky.step_definitions;


import com.meetsky.pages.DashBoardPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.pages.ProfilSettingsPage;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.MainUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class ProfileSettingsStepDef {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
       LoginPage loginPage = new LoginPage();
       loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("userPassword"));
    }


    @When("the user enters Profile Settings")
    public void theUserEntersProfileSettings() {

        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.getProfil();
    }

    @And("the user change profile settings")
    public void theUserChangeProfileSettings() {
        MainUtilities.waitFor(2);
        ProfilSettingsPage profilSettingsPage= new ProfilSettingsPage();
        profilSettingsPage.modifyProfil("Selman Durmaz","selman@gmail.com","Nederlands","Dutch");



    }


    @Then("the user verify that the modification as follows")
    public void theUserVerifyThatTheModificationAsFollows(List<String> expectedModifications) {
        ProfilSettingsPage profilSettingsPage= new ProfilSettingsPage();

        Select selectLanguage = new Select(profilSettingsPage.languageSelection);
        Select selectLocale = new Select(profilSettingsPage.localeSelection);

        List<String> actualModificaiton = new ArrayList<>();
        actualModificaiton.addAll(Arrays.asList(profilSettingsPage.fullName.getAttribute("value"),profilSettingsPage.emailSelection.getAttribute("value"),
                selectLanguage.getFirstSelectedOption().getText(),selectLocale.getFirstSelectedOption().getText()));

        System.out.println("expectedModifications = " + expectedModifications);
        System.out.println("actualModificaiton = " + actualModificaiton);

        Assert.assertTrue("verify that the modified settings is displayed", expectedModifications.equals(actualModificaiton));

    }
}
