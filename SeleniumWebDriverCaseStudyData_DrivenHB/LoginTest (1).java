package com.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.pageobject.LoginPage;


public class LoginTest {
	public WebDriver driver;

	@Parameters("browsername")
	@BeforeTest
	public void Setup(String browsername) {
		System.out.println("Browser Name is"+browsername);
		if (browsername.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            
        } else if (browsername.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            
        } else if (browsername.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://auth.hollandandbarrett.com/");
	}
	@DataProvider(name ="loginData")
	public void login(String username,String password) {
		LoginPage lp=new LoginPage(driver);
		lp.Email(username);
		lp.Password(password);
		lp.SignIn();
	}
	public void takeScreenshot(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File("./ScreenShots/Homepage.png" +result.getName()+".png");
			FileUtils.copyFile(src,dest);
		}
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
