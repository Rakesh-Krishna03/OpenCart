package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestClass;
import utilities.DataProviders;

/*
 * If Data Valid - Login Success - Test Passed - Logout
 * If Data Valid - Logic Fail - Test Failed
 * 
 * If Data Invalid - Login Fail - Test Passed
 * If Data Invalid - Login Success - Test Failed - Logout
 */

public class OpenCartDataDrivenTest extends BaseTestClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = { "DataDriven", "Master" })
	public void verifyLoginDDT(String email, String password, String expectedResult) throws InterruptedException {

		try {
			HomePage home = new HomePage(driver);
			LoginPage login = new LoginPage(driver);
			MyAccountPage accountPage = new MyAccountPage(driver);

			home.clickAccount();
			home.clickLogin();

			login.setEmail(email);
			Thread.sleep(3000);
			login.setPassword(password);
			Thread.sleep(3000);
			login.clickLogin();
			Thread.sleep(3000);

			boolean myAccountExist = accountPage.isMyAccountExist();

			if (expectedResult.equalsIgnoreCase("valid")) {
				if (myAccountExist == true) {
					Assert.assertTrue(true);
					accountPage.clickLogout();
				} else {
					Assert.assertTrue(false);
				}
			}

			if (expectedResult.equalsIgnoreCase("invalid")) {
				if (myAccountExist == true) {
					accountPage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
