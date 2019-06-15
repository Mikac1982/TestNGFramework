package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HomePage2 extends BaseClass{

	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	@FindBy(xpath="//span[text()='PIM']")
	public WebElement PIM;
	
	@FindBy(xpath="//span[text()='Add Employee']")
	public WebElement addEmployee;
	
	
	///CONSTRUCTOR!
	public HomePage2() {
		PageFactory.initElements(driver, this);
	}	
}
