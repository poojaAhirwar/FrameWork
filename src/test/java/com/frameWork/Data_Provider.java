package com.frameWork;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data_Provider {
	@DataProvider(name = "readExcel")
	public Object[][] excelData() {
		FileInputStream fis = null;
		XSSFWorkbook book = null;
		try {
			// String baseDir = System.getProperty("user.dir"); //present working directory

			fis = new FileInputStream("\"F:\\data.xlsx\"");
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
		}

		XSSFSheet sheet = book.getSheet("amazon");
		XSSFRow row = null;
		Object[][] moblie_email = new Object[sheet.getLastRowNum()][1];
		for (int rowNum = 2; rowNum < sheet.getLastRowNum(); rowNum++) {

			row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(1);
			String value = null;
			if (cell.getCellType() == CellType.NUMERIC) {
				value = String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellType() == CellType.STRING) {
				value = cell.getStringCellValue();
			}
			moblie_email[rowNum - 1][0] = value;
		}

		return moblie_email;
	}

	@DataProvider(name = "UserData")
	public Object[][] nameDataProvider() {

		Object[][] names = {  { "1234" },
				{  "poo"},{"pooja@gmail"},{"00998765433"},{"ahirwarpooja@gmail.com"} };
		return names;

	}

	
}
