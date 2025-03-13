package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

// What are all the methods required for all the test cases we can have it here

public class BaseTestClass {

	protected static WebDriver driver;

	protected Logger logger; // Log4j
	protected Properties properties;

	@BeforeClass(groups = { "Sanity", "Regression", "DataDriven", "Master" })
	@Parameters({ "browser" })
	protected void setup(String bro) throws IOException {

		FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
		properties = new Properties();
		properties.load(file);

		logger = LogManager.getLogger(this.getClass()); // Log4j2 code

		switch (bro.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser name");
			return;
		}

		driver.manage().deleteAllCookies();
//		driver.get("http://localhost/opencart/upload");
		driver.get(properties.getProperty("app.url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass(alwaysRun = true, groups = { "Sanity", "Regression", "DataDriven", "Master" })
	protected void closeBrowser() {
		driver.quit();
	}

	public String captureScreen(String testName) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String destPath = System.getProperty("user.dir") + "\\screenshotsCaptures\\" + testName + "_" + timeStamp + ".png";
		File dest = new File(destPath);

		FileUtils.copyFile(src, dest);
		src.renameTo(dest);

		return destPath;
	}
}
