package FrameWorkImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeLoginPage {

	private WebDriver driver; // class variable

	// Constructor, Purpose: To initiate the WebDriver automatically to find the
	// locators of web elements
	// without driver findElement will not work
	OrangeLoginPage(WebDriver driver) { // local variable
		this.driver = driver;
	}
	
	// Locators
	private static final By USERNAME_TEXTBHOX = By.xpath("//input[@placeholder='Username']");
	private static final By PASSWORD_TEXTBOX = By.xpath("//input[@placeholder='Password']");
	private static final By LOGIN_BUTTON = By.xpath("//button[normalize-space()='Login']");

	// Action Methods
	public void setUserName(String name) {
		driver.findElement(USERNAME_TEXTBHOX).sendKeys(name);;
	}
	
	public void setPassword(String pwd) {
		driver.findElement(PASSWORD_TEXTBOX).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(LOGIN_BUTTON).click();
	}
}
