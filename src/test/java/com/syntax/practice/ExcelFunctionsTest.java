package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionsTest {

	@Test
	public void excelTest() {
	//opening excel file and sheet 	
	ExcelUtility obj=new ExcelUtility();
	obj.openExcel(Constants.XL_FILEPATH, "Sheet1");
	String value=obj.getCellData(2, 3);
	System.out.println(value);
	
	//retrieve all values from excel and store(paste) into (DataProvider) 2D Object array
	int row=obj.getRowNum();
	int cell=obj.getColNum(0);
	
	Object[][] data=new Object[row][cell];
	//loop through each row & column
	//from 1 cause we don't need headers
	for(int i=1; i<row; i++) {
		for(int y=0; y<cell; y++) {
			//retrieve value from excel
			String value2=obj.getCellData(i, y); //retrieving and getting data 
			//store value inside 2D array-DataProvider
			data[i][y]=value2; //throwing data back to data provider
		}
	}
	
	System.out.println(data.length);
	
	}

}
