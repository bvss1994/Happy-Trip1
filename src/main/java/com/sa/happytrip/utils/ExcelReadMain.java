package com.sa.happytrip.utils;

import java.io.IOException;

public class ExcelReadMain {

	public static void main(String[] args) throws IOException {
		
		//Import Excel File
		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");
		
		//Count the total number of Columns present in the sheet
		int colCount = exr.getColumnCount("Credentials");
		System.out.println("Total number of columns present in the sheet: " + colCount);


		//Count the total number of rows present in the sheet
		int rowCount = exr.getRowCount("Credentials");
		System.out.println("Total number of rows present in the sheet: " + rowCount);
		
		System.out.println(exr.getCellData("Credentials", 0, 0));
		System.out.println(exr.getCellData("Credentials", 0, 1));
		
	}

}
