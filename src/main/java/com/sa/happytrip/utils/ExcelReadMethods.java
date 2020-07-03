package com.sa.happytrip.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReadMethods {
	
	//Import Excel File
	public FileInputStream fis = null;
	//load the input stream to a workbook object
	//Use XSSF for (.xlsx) excel file and HSSF for (.xls) excel file
	public XSSFWorkbook workbook = null;
	//get the sheet from the workbook by Sheet name
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xlFilePath;
	
	public ExcelReadMethods(String xlFilePath) throws IOException  {
		this.xlFilePath = xlFilePath;
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}
	
	public int getRowCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() + 1;
		return rowCount;
	}
	
	public int getColumnCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}
	
	public String getCellData(String sheetName, int rowNum, int colNum ) {
		try 
		{
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			
			if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) 
			{
				String cellValue = String.valueOf(cell.getNumericCellValue());
				
				if(HSSFDateUtil.isCellDateFormatted(cell)) 
				{
					DateFormat df = new SimpleDateFormat("dd/mm//yyyy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			}
			
			else if(cell.getCellType() == Cell.CELL_TYPE_BLANK) 
				return "";
			else 
				return String.valueOf(cell.getBooleanCellValue());
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return "Row " + rowNum + " or Column " + colNum + " does not exist in excel";
		}
		
	}

}

