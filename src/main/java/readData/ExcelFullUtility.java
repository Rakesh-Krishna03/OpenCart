package readData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;

public class ExcelFullUtility {
	
	public static Object[][] readExcelData(String filePath, String sheetName) throws EncryptedDocumentException, IOException{
		
		FileInputStream file = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rowCount-1][colCount];
		
		for(int i = 1; i<rowCount; i++) {
			Row row = sheet.getRow(i);
			for(int j = 0; j < colCount ; j++) {
				Cell cell = row.getCell(j);
				data[i-1][j] = getCellValue(cell);
			}
		}
		
		return data;
	}
	
	public static String getCellValue(Cell cell) {
		
		if(cell == null) 
			return "";
		
		switch(cell.getCellType()) {
		case STRING :
			return cell.getStringCellValue();
		case NUMERIC : return String.valueOf((int) cell.getNumericCellValue());
		case BOOLEAN : return String.valueOf(cell.getBooleanCellValue());
		default : return "";
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		String filePath = "D:\\RK_Surface\\ReadData\\credsRk.xlsx";
		String sheetName = "rk"; // Provide the sheet name

	    Object[][] data = readExcelData(filePath, sheetName);

	    // Printing the Excel data
	    for (Object[] row : data) {
	        for (Object cell : row) {
	            System.out.print(cell + "\t"); // Print each cell value with a tab space
	        }
	        System.out.println(); // Move to the next line after printing a row
	    }
		}
}
