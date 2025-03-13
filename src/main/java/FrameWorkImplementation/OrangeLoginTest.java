package FrameWorkImplementation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeLoginTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void testLogin() {
		OrangePageFactoryLoginPage olp = new OrangePageFactoryLoginPage(driver);
		olp.setUserName("Admin");
		olp.setPassword("admin123");
		olp.clickLogin();

		System.out.println(olp.isDashBoardVisible());
		System.out.println("success");
		Assert.assertEquals(true, olp.isDashBoardVisible());
		System.out.println("success");
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}