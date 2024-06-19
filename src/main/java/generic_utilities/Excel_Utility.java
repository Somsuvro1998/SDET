package generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * @author SOMSUVRO
	 * @param Sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String Sheetname,int rowNum,int cellNum) throws Throwable 
	{
	FileInputStream fes=new FileInputStream("./src/test/resources/Fetch.xlsx");
	Workbook book = WorkbookFactory.create(fes);
	Sheet sheet = book.getSheet(Sheetname);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.getCell(cellNum);
	String exceldata = cell.getStringCellValue();	
	return exceldata;
	
	}
	
	/**
	 * @author SOMSUVRO
	 * @param Sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFormatterData(String Sheetname, int rowNum, int cellNum) throws Throwable
	{
	FileInputStream fes=new FileInputStream("./src/test/resources/Fetch.xlsx");
	Workbook book = WorkbookFactory.create(fes);
	Sheet sheet = book.getSheet(Sheetname);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.getCell(cellNum);
	
	DataFormatter format=new DataFormatter();
	String exceldata = format.formatCellValue(cell);
	return exceldata;
	}
	public Object[][] readMultipleData(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/practice.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(SheetName);
		int lastRow=sheet.getLastRowNum()+1;
		 int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
	return obj;
	
	}
	
}
