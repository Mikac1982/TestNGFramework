package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddLocationPage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddLocationPageTest extends BaseClass{
	/* Test Case: Add Location
	1. Login to OrangeHRM
	2. From Admin --> Organization select Locations
	3. Add 5 different locations by providing complete required details (Use data provider)
	4. Save location and verify it has been successfully saved.
	*/
	
	@Test(dataProvider="add location")
	public void addLocation(String name, String country, String city, String zip) throws InterruptedException {
		
	LoginPage login=new LoginPage();
	HomePage home=new HomePage();
	AddLocationPage addLoc=new AddLocationPage();
	
	//login to the OrangeHRM
	login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	
	CommonMethods.click(home.admin);
	CommonMethods.click(home.organization);
	CommonMethods.click(home.locations);
	CommonMethods.click(home.add);
	
	Thread.sleep(4000);
	
	CommonMethods.sendText(addLoc.name, name);
	CommonMethods.click(addLoc.countryDD);
	CommonMethods.selectList(addLoc.countryList, country);
	CommonMethods.sendText(addLoc.city, city);
	CommonMethods.sendText(addLoc.zip, zip);
	
	CommonMethods.click(addLoc.saveBtn);
	
	Assert.assertTrue(addLoc.locText.isDisplayed());
	System.out.println("Location was successfully added");
	
	Thread.sleep(4000);
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
