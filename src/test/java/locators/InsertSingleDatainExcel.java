package locators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDatainExcel {

public static void main(String[] args) throws Throwable {
FileInputStream fes=new FileInputStream("./src/test/resources/Fetch.xlsx");
Workbook book = WorkbookFactory.create(fes);
Sheet sheet = book.getSheet("Sheet1");
Row row = sheet.createRow(2);
Cell cell = row.createCell(2);          
cell.setCellValue("SOMSUVRO PAL");

FileOutputStream fos=new FileOutputStream("./src/test/resources/Fetch.xlsx");
book.write(fos);
book.close();
	}
}
