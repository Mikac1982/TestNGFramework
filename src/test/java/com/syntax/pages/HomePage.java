package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	@FindBy(partialLinkText="PIM")
    public WebElement PIM;
	
    @FindBy(partialLinkText="Add Employee")
    public WebElement addEmployee;
	
    @FindBy(xpath="//div[@id='menu-content']/ul/li/a/span[2]")
	public WebElement admin;
    
    @FindBy(xpath="//span[text()='Organization']")
    public WebElement organization;
    
    @FindBy(xpath="//span[text()='Locations']")
    public WebElement locations;
    
    @FindBy(xpath="//i[text()='add']")
    public WebElement add;
    
    
  ///CONSTRUCTOR!
	public HomePage() {
		PageFactory.initElements(driver, this);
	}	
}
