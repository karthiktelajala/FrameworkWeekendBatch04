package genericActionsLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel 
{
	static String testData;
	public static String readExcel(String filepath,int sheetNum, int rowNum, int cellNum)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheetAt(sheetNum);
			Row row = sheet.getRow(rowNum);
			
			testData = row.getCell(cellNum).getStringCellValue();
			wb.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return testData;
	}
	
	public static void writeExcel(String filepath,int sheetNum, int rowNum, int cellNum, String resultData)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheetAt(sheetNum);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.createCell(cellNum);
			cell.setCellValue(resultData);
			FileOutputStream fos = new FileOutputStream(filepath);
			wb.write(fos);
			wb.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
