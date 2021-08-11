package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import com.meetsky.utilities.MainUtilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProfilSettingsPage {

    public ProfilSettingsPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath ="//input[@id='displayname']")
    public WebElement fullName;

    @FindBy(xpath ="//input[@id='email']")
    public WebElement emailSelection;

    @FindBy(xpath ="//select[@id='languageinput']")
    public WebElement languageSelection;

    @FindBy(xpath ="//select[@id='localeinput']")
    public WebElement localeSelection;

    public void modifyProfil(String name, String email,String language, String locale){
        fullName.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        emailSelection.sendKeys(Keys.CONTROL,"a",Keys.DELETE);

        MainUtilities.waitFor(2);
        fullName.sendKeys(name);
        emailSelection.sendKeys(email);

        Select selectLanguage = new Select(languageSelection);
        selectLanguage.selectByVisibleText(language);

        Select selectLocale = new Select(localeSelection);
        selectLocale.selectByVisibleText(locale);





    }

}
