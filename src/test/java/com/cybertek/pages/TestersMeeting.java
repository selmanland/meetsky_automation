package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestersMeeting extends  BasePage{

    public TestersMeeting() {
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(css="//div[text()='Testers meeting']")
    public WebElement element;

}
