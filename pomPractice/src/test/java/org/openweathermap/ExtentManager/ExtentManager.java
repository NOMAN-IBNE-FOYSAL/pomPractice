package org.openweathermap.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;

public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir")+"/reports/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter = new ExtentSparkReporter("extentReport.html");
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setDocumentTitle("Automation Reports");
		sparkReporter.config().setReportName("Automation Test Results");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		return extent;
		
	}
	
	public static String getReportName() {
		Date d = new Date();
		String fileName = "AutomationReport_"+d.toString().replace(":", "_").replace(" ", "_")+".png";
		return fileName;
	}
	
}

