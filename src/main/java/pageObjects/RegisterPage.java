package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class RegisterPage extends BasePage {

	// Constructor
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstNameTextbox;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastNameTextbox;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement eMailTextbox;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement agreePolicyCheckbox;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement messageConfirmation;

	public void setFirstName(String fName) {
		firstNameTextbox.sendKeys(fName);
	}

	public void setLastName(String lName) {
		lastNameTextbox.sendKeys(lName);
	}

	public void setEmail(String eMail) {
		eMailTextbox.sendKeys(eMail);
	}

	public void setPassword(String pwd) {
		passwordTextbox.sendKeys(pwd);
	}

	public void clickAgree() {
//		agreePolicyCheckbox.click();
//		
//		WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		ewait.until(ExpectedConditions.elementToBeClickable(agreePolicyCheckbox)).click();
		
//		agreePolicyCheckbox.sendKeys(Keys.RETURN);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(agreePolicyCheckbox).click().perform();
	}
	

	public void clickContinue() {
		continueButton.click();
//		continueButton.sendKeys(Keys.RETURN);
	}
	
	public String getConfirmationMessage() {
		try {
			return messageConfirmation.getText();
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
}
