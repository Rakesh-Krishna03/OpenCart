package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[normalize-space()='My Account']")
	private WebElement myAccountTextHeader;

//	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	@FindBy(xpath = "//div[@class='list-group mb-3']//a[text()='Logout']")
	private WebElement logoutLink;

	public boolean isMyAccountExist() {
		try {
			return myAccountTextHeader.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {
		Actions actions = new Actions(driver);
		actions.moveToElement(logoutLink).click().perform();
	}
}
