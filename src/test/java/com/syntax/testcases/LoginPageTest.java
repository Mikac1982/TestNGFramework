package com.syntax.testcases;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{

	HomePage home;
    LoginPageWithoutPageFactory login;
	
	//first way of login without using FactoryClass(hard coding)
	@Test(groups="smoke")
	public void loginToOrangeHRM() {
		
		test=report.createTest("loginToOrangeHrm");
		//we create object of class LoginPageWithoutPageFactory to test all elements
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		
		test.info("Logging in with valid credentials"); 
		
		//hard coding!
		CommonMethods.sendText(login.userName, "Admin");
		CommonMethods.sendText(login.password, "poFm62MA@Z");
		CommonMethods.click(login.btnLogin);
		
		test.info("Verifying dashboard text is displayed");
		
		
	}
	
	//second way of login, but with reading from property file;
	//no hard coding as in previous one
	@Test(groups="smoke")
	public void doLogin() {
		//when we test, ALWAYS HAVE TO CREATE AN OBJECT OF THAT CLASS!
		LoginPage login=new LoginPage();
		//getting value for keys that are stored in properties file
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		
		//creating object of HomePage class (to verify successfully login)
		HomePage home=new HomePage();
		boolean isDisplayed=home.dashboardText.isDisplayed();
		
	//	Assert.assertEquals(isDisplayed, true);
	//    Assert.assertTrue(isDisplayed);
		Assert.assertTrue(false);
		System.out.println("Successfully logged in");
		
	}
	
	/*verify user is unable to login with wrong credentials 
	 *Note: we have to identify element on LoginPage not HomePage
	 *for negative login we don't go to properties file to change value, just do hard coding 	
	 */
	@Test(groups="regression")
	public void negativeLogin() {
		//create object of LoginPage
		LoginPage login=new LoginPage();
	   
		test.info("Login in with invalid credentials");
		
		//one way: using login method from LoginPage
		login.login("admins", "test");
		String errorText=login.errorText.getText();
		test.info("");
		Assert.assertEquals(errorText, "Invalid Credentials");
		
		//the other way:
		
	//	CommonMethods.sendText(login.userName, "Admin");
	    //here we pass wrong password
	//	CommonMethods.sendText(login.password, "pass11111");
	//	CommonMethods.click(login.loginButton);
		
     //  boolean isDisplayed=login.errorText.isDisplayed();
	 //	Assert.assertTrue(isDisplayed);
	 //	System.out.println("User is NOT successfully logged in");
	}
	
	
	
	
	
	
}
