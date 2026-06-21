package library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusability {

	public static void capturedScreenshot(WebDriver driver, String screenshotName) {

		try {
			// Convert driver to TakesScreenshot
			TakesScreenshot ts = (TakesScreenshot) driver;

			// Capture screenshot
			File source = ts.getScreenshotAs(OutputType.FILE);

			// Save screenshot directly
			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));

			System.out.println("✅ Screenshot captured: " + screenshotName);

		} catch (Exception e) {

			System.out.println("❌ Screenshot failed");
			System.out.println("Error: " + e.getMessage());
		}
	}
}
