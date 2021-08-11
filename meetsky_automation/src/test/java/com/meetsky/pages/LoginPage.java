package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath ="//input[@id='user']")
    public WebElement userName;

    @FindBy(xpath ="//input[@id='password']")
    public WebElement userPassword;

    @FindBy(xpath ="//input[@id='submit-form']")
    public WebElement submit;

    public void login(String username, String password){

//        Driver.get().findElement(By.xpath("//button[@id='details-button']")).click();
//        Driver.get().findElement(By.xpath("//a[@id='proceed-link']")).click();

        userName.sendKeys(username);
        userPassword.sendKeys(password);
        submit.click();
    }


}
