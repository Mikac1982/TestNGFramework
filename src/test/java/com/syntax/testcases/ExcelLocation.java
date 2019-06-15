package com.syntax.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelLocation {

	@Test
	public void readExcel() throws IOException {
		String xlPath = "src/test/resources/testdata/AddLocations.xlsx";

		FileInputStream fis = new FileInputStream(xlPath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("AddLocations");

		int rowNum=sheet.getPhysicalNumberOfRows();
		int colNum=sheet.getRow(0).getLastCellNum();
		System.out.println(rowNum);
		System.out.println(colNum);
		
		for(int i=0; i<rowNum; i++) {
			for(int j=0; j<colNum; j++) {
				
				String cellValue=sheet.getRow(i).getCell(j).toString();
				System.out.print(cellValue+"   ");
			}
			System.out.println();
		}
		
		
	}
}
