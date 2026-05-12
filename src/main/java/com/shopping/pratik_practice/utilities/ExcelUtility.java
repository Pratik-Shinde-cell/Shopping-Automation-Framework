package com.shopping.pratik_practice.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtility {
  
	public static Object[][] getexceldata(String sheetname) throws Exception
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\Pratik\\Assignments\\Automation Project Testdata\\TestData.xlsx");
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sheet= wb.getSheet(sheetname);
		
		int rowcount= sheet.getLastRowNum();
		int colcount=sheet.getRow(0).getLastCellNum();
		
		Object[][] data= new Object[rowcount][colcount];
		DataFormatter format= new DataFormatter();
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		wb.close();
		return data;
	}
}
