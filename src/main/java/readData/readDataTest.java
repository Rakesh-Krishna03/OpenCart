package readData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class readDataTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.irctc.co.in/");
		driver.findElement(By.xpath("//a[text()=' LOGIN ']")).click();
		
		// code to read data from json files
		
		JSONObject jsonData = jsonUtility.readJsonFile("D:\\RK_Surface\\ReadData\\jsonTest.json");
		
		String username = String.valueOf(jsonData.get("username"));
		String password = (String) jsonData.get("password"); 
		
		
		// code to read data from excel file
		/*
		String username = excelUtility.readStringFromWorkbook("D:\\RK_Surface\\ReadData\\creds.xlsx", "rk", 0, 1);
		String password = excelUtility.readStringFromWorkbook("D:\\RK_Surface\\ReadData\\creds.xlsx", "rk", 1, 1);
		*/
	
		driver.findElement(By.xpath("//input[@formcontrolname='userid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
		
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Success");
	}
}
