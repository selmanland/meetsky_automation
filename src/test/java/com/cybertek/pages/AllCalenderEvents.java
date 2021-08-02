package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllCalenderEvents extends BasePage{
    Actions actions;
    public AllCalenderEvents(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    public WebElement elementOption;

    @FindBy(xpath = "//input[@value='1']")
    public WebElement numberPage;

    @FindBy(xpath ="//button[normalize-space()='25']")
    public WebElement viewPerPage;

    @FindBy(xpath = "//div[@class='btn-group dropdown']//input")
    public WebElement checkboxButton;

    @FindBy(css=".fa-filter.hide-text")
    public WebElement searchBox;

    @FindBy(css=".filter-criteria-hint")
    public WebElement titleAll;

    @FindBy(xpath = "//input[@type='text'][@name='value']")
    public WebElement sendPropety;

    @FindBy(xpath ="//tr[@class='grid-row']/td[text()='Yes']")
    public WebElement recurrentMeeting;

    @FindBy(xpath ="//button[contains(@class,'dropdown-toggle ')]")
    public WebElement perPage25;

    @FindBy(xpath =" //a[contains(text(),'100')]")
    public WebElement perPage100;

    @FindBy(xpath = "//label[contains(text(),'of')][1]")
    public WebElement totalpage;

    @FindBy(css=".grid-row")
    public List<WebElement> rows;

    @FindBy(xpath = "//i[contains(@class,'fa-chevron-right')]")
    public WebElement rightArrow;

    @FindBy(xpath = "//button[@data-toggle='dropdown']/input")
    public WebElement selectAll;

    @FindBy(xpath = "//tr[contains(@class,'grid-row')]")
    public WebElement checkboxes;


    public void getRecurrent(String recurrency){

        Driver.get().findElement(By.xpath("//tr[@class='grid-row']/td[text()='"+((recurrency.substring(0,1).toUpperCase())+recurrency.substring(1).toLowerCase()+"']"))).click();
    }

    public void getEvent(String eventTitle,String recurrency){
        searchBox.click();
        titleAll.click();
        sendPropety.sendKeys(eventTitle+""+Keys.ENTER);
        Driver.get().findElement(By.xpath("//tr[@class='grid-row']/td[text()='"+((recurrency.substring(0,1).toUpperCase())+recurrency.substring(1).toLowerCase()+"']"))).click();

        //actions.moveToElement(searchBox).click().pause(2000).moveToElement(titleAll).click().pause(2000).moveToElement(sendPropety).sendKeys(value+""+Keys.ENTER).perform();


    }




}
