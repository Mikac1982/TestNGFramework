package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
//this class store all WebElements related to that page
public class LoginPageWithoutPageFactory extends BaseClass{
    //First way:
//	public WebElement userName=driver.findElement(By.id("txtUsername"));
//	public WebElement password=driver.findElement(By.id("txtPassword"));
//	public WebElement btnLogin=driver.findElement(By.id("btnLogin"));
	
	//Second way of finding elements:
	//with PageFactory:

	@FindBy(id="txtUsername")
	public WebElement userName;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement btnLogin;
	
	public LoginPageWithoutPageFactory() {
		//initializing page object using initElements() method from PageFactory Class
		PageFactory.initElements(driver, this);
	}
	
	
}
