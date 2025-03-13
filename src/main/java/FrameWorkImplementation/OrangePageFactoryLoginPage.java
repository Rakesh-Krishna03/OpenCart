package FrameWorkImplementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrangePageFactoryLoginPage {

	WebDriver driver;

	// constructor
	OrangePageFactoryLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement USERNAME_TEXTBOX;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement PASSWORD_TEXTBOX;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement LOGIN_BUTTON;

	@FindBy(how = How.XPATH, using = "//h6[normalize-space()='Dashboard']")
	WebElement DASHBOARD_TEXT;

	// Action Methods
	public void setUserName(String name) {
		USERNAME_TEXTBOX.sendKeys(name);
	}

	public void setPassword(String pwd) {
		PASSWORD_TEXTBOX.sendKeys(pwd);
	}

	public void clickLogin() {
		LOGIN_BUTTON.click();
	}

	public boolean isDashBoardVisible() {
		return DASHBOARD_TEXT.isDisplayed();
	}
}
