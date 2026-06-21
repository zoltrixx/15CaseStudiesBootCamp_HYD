package com.SeleniumWebDriver;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebKulTestScreenshots {

	WebDriver driver;
	String URL = "https://store.webkul.com/";
	int total;

	@BeforeTest
	public void SetUp() {
		driver = new ChromeDriver();
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		String Title = driver.getTitle();
		System.out.println("The Title is: " + Title);

	}

	@Test
	public void findElementByID() throws Exception {
		Thread.sleep(5000);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/Homepage.png"));
	}


	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
