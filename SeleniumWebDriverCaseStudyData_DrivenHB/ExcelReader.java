package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
public static Object[][] getData() throws IOException{
	File src=new File("C:\\CoforgeBootCampTesting\\ExternalDocuments\\HollandAndBarretData.xlsx");
	FileInputStream fis=new FileInputStream(src);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet =wb.getSheetAt(0);
	int rows=sheet.getLastRowNum();
	Object[][] data=new Object[rows][2];
	for(int i=1;i<=rows;i++) {
		data[i-1][0]=sheet.getRow(i).getCell(0).getStringCellValue();
		data[i-1][1]=sheet.getRow(i).getCell(1).getStringCellValue();
		
	}
	wb.close();
	return data;
}
}
