package javaPrograms;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class PracticeProgram {
	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://wallpaperscraft.com/");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./bugShots/page.png");

		FileUtils.copyFile(src, dest);

		driver.findElement(By.xpath("//input[@name='query']")).sendKeys("Success", Keys.ENTER);
		WebElement element = driver.findElement(By.xpath(
				"//img[@src='https://images.wallpaperscraft.com/image/single/quote_success_failure_153171_300x168.jpg']"));

		File srcElement = element.getScreenshotAs(OutputType.FILE);
		File destElement = new File("./bugShots/element.png");

		FileHandler.copy(srcElement, destElement);

		driver.quit();
	}
}
