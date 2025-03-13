package readData;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) {
		
		switch(br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver(); 
						break;
						
		case "edge"	: driver = new EdgeDriver();
						break;
						
		case "firefox" : driver = new FirefoxDriver();
						break;
						
		default : System.out.println("Invalid Browser");
					return;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}
	
	@Test(dataProvider = "dp")
	public void login(String un, String pwd) throws InterruptedException {
		
		driver.findElement(By.id("input-email")).sendKeys(un);
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@DataProvider(name = "dp", indices = {0,4})
	public Object[][] loginData() {
		Object[][] data = {
				{"rak", "pwd1"},
				{"ram", "dws"},
				{"fre", "grt"},
				{"www", "qqq"},
				{"ddd", "hhh"}
		};
		return data;
	}
	
	@AfterClass(alwaysRun = true) 
	public void close() {
		driver.quit();
	}
}
