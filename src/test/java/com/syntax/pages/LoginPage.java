package com.syntax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.BaseClass;
//this class store all WebElements from that page
public class LoginPage extends BaseClass{

	public WebElement userName=driver.findElement(By.id("txtUsername"));
	public WebElement password=driver.findElement(By.id("txtPassword"));
	public WebElement btnLogin=driver.findElement(By.id("btnLogin"));
	
	
	
	
}
