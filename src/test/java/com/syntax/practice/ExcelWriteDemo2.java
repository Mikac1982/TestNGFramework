package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo2 {

	@Test
	public void writeExcel() throws IOException {
		
		String xlPath="src/test/resources/testdata/OrangeHrmData.xlsx";
		
		FileInputStream fis=new FileInputStream(xlPath);
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = wbook.getSheet("Sheet1");
		
		//write some values
	    sheet.getRow(0).createCell(4).setCellValue("Result");
		sheet.getRow(1).createCell(4).setCellValue("Pass");
		sheet.getRow(1).getCell(4).setCellValue("Fail");
		//add one more row
		sheet.createRow(11).createCell(0).setCellValue("Una");
		
		//write to excel
		FileOutputStream fos=new FileOutputStream(xlPath);
		wbook.write(fos);
		
		fos.close();
		wbook.close();
		fis.close();
		
		
	}
	
}
