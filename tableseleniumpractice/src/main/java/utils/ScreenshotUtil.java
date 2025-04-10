package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static void captureScreenshot(WebDriver driver, String testName) {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String destPath = "screenshots"+File.separator+testName+timestamp+".png";
		testName = testName.replaceAll("[^a-zA-Z0-9-_]", "_");
		
		try {
			Files.createDirectories(Paths.get("screenshots"));
			Files.copy(src.toPath(), Paths.get(destPath));
			System.out.println("Screenshot saved: " + destPath);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
