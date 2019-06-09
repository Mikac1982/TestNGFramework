package com.syntax.testcases;

import org.testng.annotations.Test;

import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class LoginPageTest extends BaseClass{

	@Test
	public void loginToOrangeHRM() {
		//we create object of class LoginPage to test all elements
		LoginPage login=new LoginPage();
		
		CommonMethods.sendText(login.userName, "Admin");
		CommonMethods.sendText(login.password, "poFm62MA@Z");
		CommonMethods.click(login.btnLogin);
		
	}
	
	
	
}
