package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseTestClass;

public class ExtentReportUtility implements ITestListener {
	private ExtentSparkReporter extentSparkReporter;
	private ExtentReports extentReports;
	private ExtentTest extentTests;

	String repName;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";
		extentSparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

		extentSparkReporter.config().setDocumentTitle("OpenCart Automation Report");
		extentSparkReporter.config().setReportName("OpenCart Funtional Testing");
		extentSparkReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Application", "Open Cart");
		extentReports.setSystemInfo("Module", "Admin");
		extentReports.setSystemInfo("Sub module", "Customers");
		extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Environment", "QA");

		String os = testContext.getCurrentXmlTest().getParameter("os");
		extentReports.setSystemInfo("Operationg System", os);

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extentReports.setSystemInfo("Browser", browser);

		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extentReports.setSystemInfo("Groups", includedGroups.toString());
		}
	}

	public void onTestSuccess(ITestResult result) {

		extentTests = extentReports.createTest(result.getTestClass().getName());
		extentTests.assignCategory(result.getMethod().getGroups());
		extentTests.log(Status.PASS, result.getName() + " got successfully executed");
	}

	public void onTestFailure(ITestResult result) {

		extentTests = extentReports.createTest(result.getTestClass().getName());
		extentTests.assignCategory(result.getMethod().getGroups());

		extentTests.log(Status.FAIL, result.getName() + " got failed!!!");
		extentTests.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgPath = new BaseTestClass().captureScreen(result.getName());
			extentTests.addScreenCaptureFromPath(imgPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

		extentTests = extentReports.createTest(result.getTestClass().getName());
		extentTests.assignCategory(result.getMethod().getGroups());

		extentTests.log(Status.SKIP, result.getName() + " got skipped!");
		extentTests.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {

		extentReports.flush();

		// To open the report automatically and this is optional
		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		File extentReport = new File(pathOfExtentReport);

		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

//		try {
//			URL url = new URL("file:///" + System.getProperty("user.dir") + "\\reports\\" + repName);
//
//			ImageHtmlEmail email = new ImageHtmlEmail();
//			email.setDataSourceResolver(new DataSourceUrlResolver(url));
//			email.setHostName("smtp.googlemail.com");
//			email.setSmtpPort(465);
//			email.setAuthenticator(new DefaultAuthenticator("rakesh3.raki@gmail.com", "password!"));
//			email.setSSLOnConnect(true);
//			email.setFrom("rakesh3.raki@gmail.com");
//			email.setSubject("Test Results");
//			email.setMsg("Please find the attached report....");
//			email.addTo("rakeshkumar.srikrishna@outlook.com");
//			email.attach(url, "extent report", "please check report.!!");
//			email.send();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
