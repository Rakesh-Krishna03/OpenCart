package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver); // Passing this driver to the parent class so that driver gets initiated
						// (Inheritance-Re-usability)
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement register;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Login']")
	private WebElement login;
	
	public void clickAccount()
	{
		myAccount.click();
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void clickLogin() {
		login.click();
	}
}
