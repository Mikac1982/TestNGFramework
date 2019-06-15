package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddEmployeePage2 extends BaseClass{

	//https://milena1982-trials65.orangehrmlive.com/auth/login
	//password=poFm62MA@Z
	
	 /* US24548: Add Employee Details
    TestCase: Add Employee Verification
    Step 1: Login to the OrangeHRM
    Step 2: Click on PIM
    Step 3: Click on Add Employee
    Step 4: Enter fName, lName, select Location
    Step 5 Click Save
    Step 6: Verify employee is added
    */
	
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="middleName")
	public WebElement middleName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="employeeId")
	public WebElement id;
	
	//to clic on drop down
	@FindBy(xpath="//div[@id='location_inputfileddiv']//input")
	public WebElement location;

	//drop down
	@FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
	public WebElement locationList;
	
	@FindBy(xpath="//a[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy(id="pim.navbar.employeeName")
	public WebElement empCheck;;
	
	//initializing all variables
	public AddEmployeePage2() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
}
