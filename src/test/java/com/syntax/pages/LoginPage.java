package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
                     //so we can access to driver
public class LoginPage extends BaseClass{

	//locating WebElements using @FindBy annotation
	@FindBy(id="txtUsername")
	public WebElement userName;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy(css="img[src*='logo.png']")
	public WebElement logo;
	
   //task to do negative login
	@FindBy(css="div[class='toast-message']")
	public WebElement errorText;
	

	//someone have to perform initialization of our variables
	//constructor is doing that:
	public LoginPage() {
		//there are 4 static methods--> 4 different ways to initialize all the variables
		PageFactory.initElements(driver, this);
	}
	
	//to Add Employee Details:
	//step 1: login to OrangeHRM 
	public void login(String uname, String pwd) {
		CommonMethods.sendText(userName, uname);
		CommonMethods.sendText(password, pwd);
		CommonMethods.click(loginBtn);
	}
	
	
	
	
	
	
	
	
	
}
