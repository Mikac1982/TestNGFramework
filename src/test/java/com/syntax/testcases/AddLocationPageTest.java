package com.syntax.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddLocationPage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class AddLocationPageTest extends BaseClass{
	/* Test Case: Add Location
	1. Login to OrangeHRM
	2. From Admin --> Organization select Locations
	3. Add 5 different locations by providing complete required details (Use data provider)
	4. Save location and verify it has been successfully saved.
	*/
	
//	@Test(dataProvider="add location")
	@Test(dataProvider="Location data")
	public void addLocation(String name, String country, String city, String zip) {
		
	LoginPage login=new LoginPage();
	HomePage home=new HomePage();
	AddLocationPage addLoc=new AddLocationPage();
	
	login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	
	CommonMethods.click(home.admin);
	CommonMethods.click(home.organization);
	CommonMethods.click(home.locations);
	CommonMethods.click(home.add);
	
	CommonMethods.sendText(addLoc.name, name);
	CommonMethods.click(addLoc.countryDD);
	CommonMethods.selectList(addLoc.countryList, country);
	CommonMethods.sendText(addLoc.city, city);
	CommonMethods.sendText(addLoc.zip, zip);
	
	CommonMethods.click(addLoc.saveBtn);
	
	AssertJUnit.assertTrue(addLoc.locText.isDisplayed());
	System.out.println("Location was successfully added");
	
	}
	
	@DataProvider(name="Location data")
	public Object[][] getLocationData() {
		
		ExcelUtility  obj=new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "AddLocation");

		int rows=obj.getRowNum();
		int cols=obj.getColNum(0);

		Object[][] data=new Object[rows-1][cols];
		for (int i=1; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				String value=obj.getCellData(i, j);
				data[i-1][j]=value;
			}
		}
	return data;
	}
	
	@DataProvider(name="add location")
	public Object[][] getLocation(){
	Object[][] data=new Object[4][4];
	
	data[0][0]="Natalija";
	data[0][1]="Serbia and Montenegro";
	data[0][2]="Beograd";
	data[0][3]="11000";

	data[1][0]="Ben";
	data[1][1]="Spain";
	data[1][2]="Madrid";
	data[1][3]="28001";

	data[2][0]="Dani";
	data[2][1]="Brazil";
	data[2][2]="Sao Paulo";
	data[2][3]="10021";
	
	data[3][0]="Jorgos";
	data[3][1]="Greece";
	data[3][2]="Atina";
	data[3][3]="03042";

	return data;
	
	}
	
	
}
