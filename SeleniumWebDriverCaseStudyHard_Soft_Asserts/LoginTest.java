package com.screenshotdemoHollandandBarret;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class LoginTest {
	WebDriver driver;
	String url = "https://www.hollandandbarrett.com/";

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

		driver.navigate().to(url);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void loginTest() throws InterruptedException {

		Actions act = new Actions(driver);

		
		WebElement ele1 = driver.findElement(
				By.xpath("//button[@class='MyHBNewLoyalty-module_container__XtY9q']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]"));

		act.moveToElement(ele1).build().perform();


		
		driver.findElement(By.xpath("//button[@class='MyHBNewLoyalty-module_container__XtY9q']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]]")).click();

	
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("souviklayek888@gmail.com");

		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Qwerty8458@");

	
		driver.findElement(By.xpath("//button[@name='action']")).click();

		
		WebElement ele2 = driver.findElement(By.xpath("//span[@aria-label='SOUVIK']"));

		act.moveToElement(ele2).build().perform();

		driver.findElement(By.linkText("//a[normalize-space()='H&B&Me Rewards']")).click();

		Assert.assertEquals("Login", "Logout");
	}

	@AfterMethod
	public void takeScreenshot(ITestResult result)
			throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File dest = new File("./ScreenShots/Homepage.png"+ result.getName()+ ".png");

			FileUtils.copyFile(src, dest);

			System.out.println("Screenshot Captured");
		}
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}
}
