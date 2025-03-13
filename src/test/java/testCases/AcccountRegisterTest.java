package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseTestClass;

public class AcccountRegisterTest extends BaseTestClass {

	private static final String FIRST_NAME = "Ram";
	private static final String LAST_NAME = "Krish";
	private static final String EMAIL = "@gmail.com";
	private static final String PASSWORD = "ram123";
	private static final String CONFIRMATION_MESSAGE = "Your Account Has Been Created!";

	private String randomData = RandomStringUtils.randomAlphabetic(5);

	@Test(groups = { "Regression", "Master" })
	public void testSuccessfulRegistration() {
		logger.info("***** Starting AcccountRegisterTest *****");
		logger.trace("Trace");

		try {
			HomePage homePage = new HomePage(driver);
			RegisterPage registerPage = new RegisterPage(driver);

			homePage.clickAccount();
			logger.info("Clicked on Account link");
			homePage.clickRegister();
			logger.info("Clicked on Register link");

			Assert.assertEquals(driver.getTitle(), "Register Account");

			logger.info("Providing customer details");
			registerPage.setFirstName(FIRST_NAME);
			registerPage.setLastName(LAST_NAME);
			registerPage.setEmail(randomData + EMAIL);
			System.out.println(randomData + EMAIL);
			registerPage.setPassword(PASSWORD);
			registerPage.clickAgree();
			registerPage.clickContinue();

			logger.debug("Debug Logs...");
			String confirmationMessage = registerPage.getConfirmationMessage();

			logger.info("validating confirm message");
			Assert.assertEquals(confirmationMessage, CONFIRMATION_MESSAGE);
			System.out.println("Success");
		} catch (Exception e) {
			logger.error("Test Failed!!");
			logger.debug("Debug Logs...");
			Assert.fail();
		}
		logger.info("***** Finished AcccountRegisterTest *****");
	}
}
