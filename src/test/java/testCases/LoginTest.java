package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestClass;

public class LoginTest extends BaseTestClass {

	private HomePage home;
	private LoginPage login;
	private MyAccountPage accountPage;

	@Test(groups = { "Sanity", "Master" })
	public void testSuccessfulLogin() throws InterruptedException {

		logger.info("*** START *** LOGIN TEST ***");
		try {
			home = new HomePage(driver);
			login = new LoginPage(driver);
			accountPage = new MyAccountPage(driver);

			home.clickAccount();
			home.clickLogin();

			login.setEmail(properties.getProperty("email"));
			login.setPassword(properties.getProperty("password"));
			login.clickLogin();

			Assert.assertEquals(accountPage.isMyAccountExist(), true, "ASsertion failed");
		} catch (Exception e) {
			Assert.fail();
		}
//		Thread.sleep(5000);
		logger.info("*** END *** LOGIN TEST ***");
		System.out.println(System.getProperty("user.dir"));
	}

}
