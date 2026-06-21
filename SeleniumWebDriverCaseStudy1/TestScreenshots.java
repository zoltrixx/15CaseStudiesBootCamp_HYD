package screenShotsDemo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import library.Reusability;

public class TestScreenshots {

	@Test
	public void Browser() throws Exception {

		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("https://store.webkul.com/");
		driver.manage().window().maximize();

		// Screenshot 1
		Reusability.capturedScreenshot(driver, "A_Launch_Application");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@class='wk-navbar']")).click();

		// Screenshot 2
		Reusability.capturedScreenshot(driver, "B_WebKul");

		driver.quit();
	}
}
