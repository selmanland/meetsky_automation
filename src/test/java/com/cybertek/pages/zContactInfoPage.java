package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class zContactInfoPage extends BasePage{
    public zContactInfoPage (){
        PageFactory.initElements(Driver.get(),this);
    }
    public WebElement getName(String name){
        return Driver.get().findElement(By.xpath("//h1[text()='"+name+"']"));
    }
}
