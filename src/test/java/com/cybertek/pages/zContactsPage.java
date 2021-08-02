package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class zContactsPage extends  BasePage{

    public zContactsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

       // @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
        //public WebElement email;

        public  WebElement getEmail(String email) {
           return Driver.get().findElement(By.xpath("//td[contains(text(),'"+email+"')][@data-column-label='Email']"));

        }
}
