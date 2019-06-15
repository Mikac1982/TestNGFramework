package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class LoginPage2 extends BaseClass{

	//locating WebElements using (another way) @FindBy annotation--> Page Factory
	@FindBy(id="txtUsername")
	public WebElement username; //instance variables
	
	@FindBy(name="txtPassword")
	public WebElement password;

	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy(css="img[src*='logo.png']")
	public WebElement logo;
	
	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboard;
	
	@FindBy(css="div.toast-message")
	public WebElement errorMessage;
	
	//constructor
	public LoginPage2() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String uname, String pwd) {
		CommonMethods.sendText(username, uname);
		CommonMethods.sendText(password, pwd);
		CommonMethods.click(loginBtn);
	}
	
	
	
	
}
