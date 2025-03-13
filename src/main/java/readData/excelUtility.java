package readData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtility {

	public static String readStringFromWorkbook (String filePath, String sheetName, int rowNo, int colNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(colNo);
		
		String cellValue = cell.getStringCellValue();
		
		wb.close();
		return cellValue;
	}
	
public static double readDoubleFromWorkbook (String filePath, String sheetName, int rowNo, int colNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(colNo);
		
		double cellValue = cell.getNumericCellValue();
		
		return cellValue;
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		System.out.println(readStringFromWorkbook("D:\\RK_Surface\\ReadData\\cred.xlsx", "rk", 0, 0));
		System.out.println(readStringFromWorkbook("D:\\RK_Surface\\ReadData\\cred.xlsx", "rk", 1, 0));
	}
}
