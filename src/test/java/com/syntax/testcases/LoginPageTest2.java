package com.syntax.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.LoginPage2;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.practice.HomePage2;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest2 extends BaseClass{

	@Test(enabled=false)
	public void loginToOrangeHRM() {
		
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		                                     
		CommonMethods.sendText(login.userName, "Admin");
		CommonMethods.sendText(login.password, "poFm62MA@Z");
		CommonMethods.click(login.btnLogin);
	}
	
	@Test
	public void doLogin() {
		
		LoginPage2 login=new LoginPage2();
		
		CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		//verification
		HomePage2 home=new HomePage2();
		//boolean isDisplayed=home.dashboardText.isDisplayed();
		AssertJUnit.assertTrue(home.dashboardText.isDisplayed());
		System.out.println("Successfully logged in!");
	}
	
	@Test
	public void negativeLogin() {
		
		LoginPage2 login=new LoginPage2();
		 //this is hard coding!
	//	CommonMethods.sendText(login.username, "Admin");
	//  CommonMethods.sendText(login.password, "06I@PjFbgM");	
	//	CommonMethods.click(login.loginBtn);
		
		//we use method we created for login and pass wrong value
		login.login("Admin", "pass");
		
	//	String errorText=login.errorMessage.getText();
	//	System.out.println(errorText);
		
	    AssertJUnit.assertTrue(login.errorMessage.isDisplayed());
	    System.out.println("Error message is displayed, not able to login!");
	}
	
	
}
