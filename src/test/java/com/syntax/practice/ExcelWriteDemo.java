package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {

	@Test
	public void writeExcel() throws Exception {
		
    String xlPath="src/test/resources/testdata/OrangeHrmData.xlsx";
	
	FileInputStream fis=new FileInputStream(xlPath);
	//open workbook &sheet
	XSSFWorkbook wbook=new XSSFWorkbook(fis);
	XSSFSheet sheet = wbook.getSheet("EmployeeDetails");
	
	//write some values
	//we creating new column in the first row
	sheet.getRow(0).createCell(4).setCellValue("Result");
	sheet.getRow(1).createCell(4).setCellValue("Pass");
	//now we just change value in 2 row from Pass to Fail
	sheet.getRow(1).getCell(4).setCellValue("Fail"); 
	sheet.getRow(8).createCell(4).setCellValue("Pass");
	sheet.getRow(8).getCell(4).setCellValue("");
	sheet.createRow(11).createCell(0).setCellValue("Mehmet");
	
    //write to excel
	FileOutputStream fos=new FileOutputStream(xlPath);
	wbook.write(fos);
	
	//close file and opend streams
	fis.close();
	fos.close();
	wbook.close();
	
	
	
	}

}
