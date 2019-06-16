package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage2;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.practice.HomePage2;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest2 extends BaseClass{

	@Test(enabled=false)
	public void loginToOrangeHRM() {
		
	//	test=report.createTest("Positive login");
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		test.info("Logging in with valid credentials"); 
		
		
		CommonMethods.sendText(login.userName, "Admin");
		CommonMethods.sendText(login.password, "poFm62MA@Z");
		CommonMethods.click(login.btnLogin);
		
		test.info("Verifying dashboard text is displayed");
		
		 HomePage home=new HomePage();
	     boolean isDisplayed = home.dashboardText.isDisplayed();
	     Assert.assertTrue(isDisplayed);
	    
	}
	
	@Test(groups="smoke")
	public void doLogin() {
		
	//    test=report.createTest("Login verification 2");
		LoginPage2 login=new LoginPage2();
		
		test.info("Logging in with valid credentials");
		
		CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		
		test.info("Verifying dashboard text is displayed");
		
		//verification
		HomePage2 home=new HomePage2();
		//boolean isDisplayed=home.dashboardText.isDisplayed();
		Assert.assertTrue(home.dashboardText.isDisplayed());
		System.out.println("Successfully logged in!");
	}
	
	@Test(groups="regression")
	public void negativeLogin() {
		
		LoginPage2 login=new LoginPage2();
		 //this is hard coding!
	//	CommonMethods.sendText(login.username, "Admin");
	//  CommonMethods.sendText(login.password, "06I@PjFbgM");	
	//	CommonMethods.click(login.loginBtn);
		
		 test.info("Logging in with In Valid credentials");
		 
		//we use method we created for login and pass wrong value
		login.login("Admin", "pass");
		
	//	String errorText=login.errorMessage.getText();
	//	System.out.println(errorText);
		
	//	test.info("Verifying error message "+errorMessage); // ???????????
	
	    Assert.assertTrue(login.errorMessage.isDisplayed());
	    System.out.println("Error message is displayed, not able to login!");
	}
	
	
}
