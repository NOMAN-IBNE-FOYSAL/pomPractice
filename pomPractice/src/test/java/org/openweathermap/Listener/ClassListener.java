package org.openweathermap.Listener;



import org.openweathermap.ExtentManager.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ClassListener implements ITestListener{
	
	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test = extent.createTest(result.getTestClass().getName()+"::"+result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String logText = "<b>Test Method" + result.getMethod().getMethodName()+"Successful</b>";
		Markup m = MarkupHelper.createLabel(logText,ExtentColor.GREEN);
		extentTest.get().log(Status.PASS,m);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String logText = "<b>Test Method" + result.getMethod().getMethodName()+"Failed</b>";
		Markup m = MarkupHelper.createLabel(logText,ExtentColor.RED);
		extentTest.get().log(Status.FAIL,m);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String logText = "<b>Test Method" + result.getMethod().getMethodName()+"Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText,ExtentColor.YELLOW);
		extentTest.get().log(Status.PASS,m);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		;
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		if(extent!=null) {
			extent.flush();
		}
	}
	
	

}
