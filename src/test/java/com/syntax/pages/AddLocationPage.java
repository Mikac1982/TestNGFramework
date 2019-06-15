package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddLocationPage extends BaseClass{
    /* Test Case: Add Location
	1. Login to OrangeHRM
	2. From Admin --> Organization select Locations
	3. Add 5 different locations by providing complete required details (Use data provider)
	4. Save location and verify it has been successfully saved.
	*/
	
	@FindBy(id="name")
	public WebElement name;
	
	@FindBy(xpath="//div[@id='countryCode_inputfileddiv']//input")
	public WebElement countryDD;

	@FindBy(xpath="//div[@id='countryCode_inputfileddiv']//ul")
	public WebElement countryList;
	
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="zipCode")
	public WebElement zip;
	
	@FindBy(xpath="//a[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy(xpath="//a[text()='Save']")
	public WebElement locCheck;
	
	@FindBy(xpath="//li[text()='Locations']")
	public WebElement locText;
	
	
	public AddLocationPage() {
		PageFactory.initElements(driver, this);
	}
	
}
