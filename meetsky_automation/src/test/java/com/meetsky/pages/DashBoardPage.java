package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import com.meetsky.utilities.MainUtilities;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import javax.swing.*;

public class DashBoardPage{

    public DashBoardPage(){
        PageFactory.initElements(Driver.get(),this);

    }

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']/img")
    public WebElement profilButton;

    @FindBy(xpath = "//li[@data-id='settings']")
    public WebElement settingsButton;

    public void getProfil(){

        profilButton.click();
        MainUtilities.waitForPageToLoad(2);

        settingsButton.click();





    }


}
