package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement eMailAddressTextbox;
	
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	private WebElement loginButton;
	
	public void setEmail(String email) {
		eMailAddressTextbox.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		passwordTextbox.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
}
