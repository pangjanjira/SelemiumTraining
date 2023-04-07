package common;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.testUtils;

public class Listeners extends testUtils implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.setProperty("org.uncommons.reportng.title", "Reportng Test");
		Reporter.log("Method name is - " +result.getName());
		System.out.println("Test case is starting");

	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Status of execution is - " +result.getStatus());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed - screenshot captured");
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=\"C:\\Users\\j\\eclipse-workspace\\SelemiumTraining\\screenshot\\Sat-Mar-04-14-52-24-ICT-2023.png\">Test Results</a>");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
	
	

}
