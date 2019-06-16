package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionsTest2 {

	@Test
	public void excelTest() {
		
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "Sheet1");	
		
		//retrieve all values from excel and store(paste) into (DataProvider) 2D Object array
		int rows=obj.getRowNum();
		int cols=obj.getColNum(0);
		
		Object[][] data=new Object[rows][cols];
		
		for(int i=1; i<rows; i++) {
			for(int y=0; y<cols; y++) {
				
				String value=obj.getCellData(i, y);
				data[i-1][y]=value;
			}
		}
		System.out.println(data.length);
		
		
		
	}
}
