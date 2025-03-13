package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = ".\\testData\\loginCredentials.xlsx";

		ExcelUtility xlUtility = new ExcelUtility(path);

		int totalRows = xlUtility.getRowCount("Sheet1");
		int totalCols = xlUtility.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalRows][totalCols]; // 2 dime array which can store cell data

		for (int i = 1; i <= totalRows; i++) {	// 1 
			for (int j = 0; j < totalCols; j++) {	// 0
				loginData[i - 1][j] = xlUtility.getCellData("Sheet1", i, j);
			}
		}

		return loginData; // returns 2 dimensional array
	}

	// DataProvider 2

	// DataProvider 3
}
