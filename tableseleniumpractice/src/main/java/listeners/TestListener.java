package listeners;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {
	
	private static ExtentReports extent = ExtentManager.getExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}
	
	 @Override
	    public void onTestFailure(ITestResult result) {
	        extentTest.get().log(Status.FAIL,"Test Failed "+ result.getThrowable());
	        
	        Object testClass = result.getInstance();
	        WebDriver driver = ((BaseTest)testClass).getDriver();
	        
	        String destPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
	        
	        extentTest.get().addScreenCaptureFromPath(System.getProperty("user.dir")+File.separator+destPath);
	        
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	       extentTest.get().log(Status.SKIP,"Test skipped "+ result.getThrowable());
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("Test Suite Started: " + context.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    	extent.flush();
	        System.out.println("Test Suite Finished: " + context.getName());
	    }
	

}
