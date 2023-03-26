/*package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("dd-M-yyyy hh.mm.ss").format(new Date());//timeStamp
		repName = "Test-Report-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter(System.getProperty("C:\\Users\\Mohan\\Documents\\Rest Assured\\PetStoreAutomation\\reports\\" + repName));// specify location of the
																								// report

		sparkReporter.config().setDocumentTitle("RestAssured Automation Report"); // Tile of report
		sparkReporter.config().setReportName("PetStore"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "PetStore");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Mohan");
	}

	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getName()); // create new entry in th report
		test.assignCategory(tr.getMethod().getGroups());
		test.createNode(tr.getName());
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName()); // create new entry in th report
		test.createNode(tr.getName());
		test.assignCategory(tr.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, tr.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName()); // create new entry in th report
		test.createNode(tr.getName());
		test.assignCategory(tr.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skiped");
		test.log(Status.SKIP, tr.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
*/