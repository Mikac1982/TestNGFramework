package com.syntax.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class AddEmployeePageTest extends BaseClass{

    @Test(dataProvider="employee details")
    public void AddEmployee(String fName, String mName, String lName, String location ) throws InterruptedException {
    	
    	//we have to create object of each Page; then we have access to all variables 
        LoginPage login=new LoginPage();
        HomePage home=new HomePage();
        AddEmployeePage addEmp=new AddEmployeePage();
        
        //step 1: login to the OrangeHRM
        //calling method login from  LoginPage
        login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
 
        //step 2:  navigate to add Employee
        CommonMethods.click(addEmp.PIM);
        //step 3: 
        CommonMethods.click(addEmp.addEmployee);
        //step 4: enter employee details
      //CommonMethods.sendText(obj.firstName, "firstName");
      //CommonMethods.sendText(obj.middleName, "middleName");
      //CommonMethods.sendText(obj.lastName, "lastName");
        CommonMethods.sendText(addEmp.firstName, fName);
        
        CommonMethods.sendText(addEmp.lastName, lName);
        CommonMethods.sendText(addEmp.middleName, mName);
        CommonMethods.click(addEmp.location);
        
        //1. identify list
        //2. get all children with li tags
        //3. loop through each li tag and get text
        //4. if text is matching then we click
        //5. break
        
        //drop down written using <li> tag, not <select
        //using common method for SelectList
        CommonMethods.selectList(addEmp.locationList, location);
        CommonMethods.click(addEmp.saveBtn);
        
        //verify employee is added
    	CommonMethods.waitForElementBeClickable(addEmp.empCheck, 20);
    	String verifText=addEmp.empCheck.getText();
    //  String verifText=addEmp.empCheck.getText().trim();
        System.out.println(verifText);
        AssertJUnit.assertEquals(verifText, fName+" "+lName); //3 times will execute 
        System.out.println("Employee was successfully added");

        
        Thread.sleep(2000);
    }
	
	@DataProvider(name="employee details")
	public Object[][] getData(){
		Object[][] data=new Object[3][4];
		//1 set
		data[0][0]="John";
		data[0][1]="Snow";
		data[0][2]="White";
		data[0][3]="HQ";   //location
		//2 set
		data[1][0]="Jane";
		data[1][1]="Rain";
		data[1][2]="Yellow";
		data[1][3]="West Office";
		//3 set
		data[2][0]="Arya";
		data[2][1]="Snow";
		data[2][2]="Blue";
		data[2][3]="North Office";
		
		return data;
	}
	
	@DataProvider(name="Emoloyee Data")
	public Object getEmpData() {
		
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "Sheet1");
		
		int rows=obj.getRowNum();
		int cols=obj.getColNum(0);
		
		Object[][] data=new Object[rows-1][cols];
		
		for(int i=1; i<rows; i++) {
			for(int y=0; y<cols; y++) {
				
				String value=obj.getCellData(i, y);
				data[i-1][y]=value;
			}
		}
	return data;
		
		
	}
	
}
