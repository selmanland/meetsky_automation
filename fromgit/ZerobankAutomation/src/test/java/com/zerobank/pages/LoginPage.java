package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css="button#signin_button")
    public WebElement signin;

    @FindBy(xpath="//input[@type='text']")
    public WebElement login;

    @FindBy(xpath="//input[@type='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement signButton;


    @FindBy(xpath = "//div[contains(text(),'are wrong')]")
    public WebElement errorMessage;

    public void login(String user, String userpassword){
        signin.click();

        login.sendKeys(user);
        passwordBox.sendKeys(userpassword);
        signButton.click();

    }

}
