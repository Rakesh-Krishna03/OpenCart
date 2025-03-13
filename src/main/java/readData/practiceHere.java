package readData;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class practiceHere {
	
	WebDriver driver; 
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String bro) {
		
		switch(bro) {
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		default: System.out.println("Invalid Browser"); return; 
		}
		
		driver.get("https://github.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test (dataProvider = "dp")
	public void testLogin(String userName, String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='login_field']")).clear();
		driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	@DataProvider(name = "dp")
	public Object[][] testData(){
		Object[][] data = {
				{"rak","123r"},
				{"kum","1456q"}
		};
		return data;
	}
}