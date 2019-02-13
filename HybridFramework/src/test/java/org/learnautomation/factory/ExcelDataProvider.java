package org.learnautomation.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb=null;
	public ExcelDataProvider()
	{
		
		
			try {
				File src= new File("C:/Users/mutyalamma talli/workspace/HybridFramework/TestData/ProjectData.xlsx");
				FileInputStream fis=new FileInputStream(src);
wb= new XSSFWorkbook(fis);
			} catch (FileNotFoundException e) {
				System.out.println("File not found" +e.getMessage());
			} catch (IOException e) {
			System.out.println("Exception" + e.getMessage());
			}
    
}
	public ExcelDataProvider(String excelpath)
	{
		
		
			try {
				File src= new File(excelpath);
				FileInputStream fis=new FileInputStream(src);
wb= new XSSFWorkbook(fis);
			} catch (FileNotFoundException e) {
				System.out.println("File not found" +e.getMessage());
			} catch (IOException e) {
			System.out.println("Exception" + e.getMessage());
			}

	         

}
	public String getStringData(String sheetname, int row, int col)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		
	}
	public String getStringData(int sheetno, int row, int col)
	{
		
				return wb.getSheetAt(sheetno).getRow(row).getCell(col).getStringCellValue();
		
		
	}
	public double getStringIntegerData(String sheetname, int row, int col)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
		
	}
	public int getStringFloatData(String sheetname, int row, int col)
	{
		return (int)wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
		
	}
}