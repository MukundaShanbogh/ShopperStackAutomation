package com.ty.shoppersstack.common;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {
	public String readExcel(String sheetName, int row, int cell) throws IOException {
		FileInputStream fis = new FileInputStream(CommonConstant.EXCEL_PATH);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}

	public Sheet getSheet(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(CommonConstant.EXCEL_PATH);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		return wb.getSheet(sheetName);
	}
}