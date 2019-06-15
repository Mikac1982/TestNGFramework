package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
                     //so we can access to driver
public class LoginPage extends BaseClass{

	//locating WebElements using (another way) @FindBy annotation--> Page Factory
	@FindBy(id="txtUsername")
	public WebElement userName;  //instance variables
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy(css="img[src*='logo.png']")
	public WebElement logo;
	
   //task to do negative login
	@FindBy(css="div[class='toast-message']")
	public WebElement errorText;
	

	//someone have to perform initialization of instance variables
	//CONSTRUCTOR is initializing instance variables using PageFactory class
	public LoginPage() {
		//there are 4 static methods--> 4 different ways to initialize all the variables
		PageFactory.initElements(driver, this);
	}
	
	//we create method for login (for any action we want do do, first we have to login using this method)
	//to Add Employee Details:
	//step 1: login to OrangeHRM 
	public void login(String uname, String pwd) {
		CommonMethods.sendText(userName, uname);
		CommonMethods.sendText(password, pwd);
		CommonMethods.click(loginBtn);
	}
	
	
	
	
	
	
	
	
	
}
