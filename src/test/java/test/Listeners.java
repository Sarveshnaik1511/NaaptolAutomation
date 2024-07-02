package test;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import utility.Reports;
import utility.Screenshot;

public class Listeners extends BaseTest implements ITestListener{
	
	public void onStart(ITestContext result) {
		reports =Reports.configureReports();
	}
	
	public void onFinish(ITestContext result) {
		reports.flush();
	}

	public void onTestStart(ITestResult result) {

	} 

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName());

		try {
			Screenshot.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName());
	}
	

}
