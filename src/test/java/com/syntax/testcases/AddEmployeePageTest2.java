package com.syntax.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.syntax.pages.AddEmployeePage2;
import com.syntax.pages.HomePage2;
import com.syntax.pages.LoginPage2;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddEmployeePageTest2 extends BaseClass{

	@Test(dataProvider="employee details")
	public void addEmployee(String fName, String mName, String lName, String location) throws InterruptedException {
	
	LoginPage2 login=new LoginPage2();
	HomePage2 home=new HomePage2();
	AddEmployeePage2 addEmp=new AddEmployeePage2();
	//login to the OrangeHRM
	login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
    CommonMethods.click(home.PIM);
	CommonMethods.click(home.addEmployee);
	
	CommonMethods.sendText(addEmp.firstName, fName);
	CommonMethods.sendText(addEmp.middleName, mName);
	CommonMethods.sendText(addEmp.lastName, lName);
//	CommonMethods.sendText(addEmp.id, "00133");
	
	//to click on drop down
	CommonMethods.click(addEmp.location);
	
	//this DD is not written using <select> tag, but it's written using with <li> tag
	//1. identify list
    //2. get all children(elements) with li tags
    //3. loop through each li tag and get text
    //4. if text is matching then we click
    //5. break
	
//	CommonMethods.selectList(addEmp.locationList, location);

		List<WebElement> listLocations = addEmp.locationList.findElements(By.tagName("li"));
		for (WebElement li : listLocations) {
			String liText = li.getAttribute("innerHTML");

			if (liText.contains(location)) {
				li.click();
				break;
			}
		}
	
	CommonMethods.click(addEmp.saveBtn);
	
//	CommonMethods.waitForElementBeClickable(addEmp.empCheck, 20);
	String verifText=addEmp.empCheck.getText();
	System.out.println(verifText);
	
	Assert.assertEquals(verifText, fName+" "+lName);
	System.out.println("Employee was successfully added");

	Thread.sleep(4000);
 }

	@DataProvider(name="employee details")
	public Object[][] getData(){
	Object[][] data=new Object[3][4];	
	//1 set
	data[0][0]="John";
	data[0][1]="Snow";
	data[0][2]="White";
	data[0][3]="HQ";
	//2 set
	data[1][0]="Jane";
	data[1][1]="Rain";
	data[1][2]="Yellow";
	data[1][3]="West Office";
	//3 set
	data[2][0]="Arya";
	data[2][1]="Sunny";
	data[2][2]="Blue";
	data[2][3]="North Office";
		
	return data;
	}

}
