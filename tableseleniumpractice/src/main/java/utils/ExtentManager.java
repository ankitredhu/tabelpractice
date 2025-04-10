package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static  ExtentReports getExtentReports() {
		if(extent==null) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Regression suite");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
			
		}
		
		return extent;
		
	}

}
