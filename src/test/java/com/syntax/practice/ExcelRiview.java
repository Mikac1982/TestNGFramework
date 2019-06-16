package com.syntax.practice;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRiview {

	@Test
	public void readExcel() throws Exception {
		
	String xlPath="src/test/resources/testdata/OrangeHrmData.xlsx";
	
	FileInputStream fis=new FileInputStream(xlPath);
	//open workbook
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	//open specific sheet
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	//access value of specific cell
	String value=sheet.getRow(6).getCell(0).toString();
	System.out.println(value);
	
	//get number of rows and columns
	int rows=sheet.getPhysicalNumberOfRows();
	int cols=sheet.getRow(0).getLastCellNum();
	System.out.println("Number of rowsand cols: "+rows+" "+cols);
	
	//get value from each cell 1 by 1
	for(int i=1; i<rows; i++) {
		for(int j=0; j<cols; j++) {
			
			String cellValue=sheet.getRow(i).getCell(j).toString();
		//	System.out.println(cellValue);
			System.out.print(cellValue+"   ");
		}
		System.out.println();
	}
	
	workbook.close();
	fis.close();
	
	}
}
