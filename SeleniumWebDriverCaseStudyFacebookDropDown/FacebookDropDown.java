package com.SeleniumFacebookDropDown;

public class FacebookDropDown {

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	WebDriver driver;

	String url = "https://www.facebook.com/campaign/landing.php?";

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void dropdownTest() throws Exception {

		// Wait for page load (basic handling)
		Thread.sleep(5000);

		// Locate Date (Day) dropdown
		WebElement dayDropdown = driver.findElement(By.id("day"));
		Select day = new Select(dayDropdown);

		// Select using different methods
		day.selectByIndex(5);
		System.out.println("Selected by Index (Day): " + day.getFirstSelectedOption().getText());

		day.selectByValue("10");
		System.out.println("Selected by Value (Day): " + day.getFirstSelectedOption().getText());

		day.selectByVisibleText("15");
		System.out.println("Selected by Visible Text (Day): " + day.getFirstSelectedOption().getText());

		// Print all values of Day dropdown
		List<WebElement> dayOptions = day.getOptions();
		System.out.println("All Day Values:");
		for (WebElement option : dayOptions) {
			System.out.println(option.getText());
		}

		// Count Day items
		System.out.println("Total number of Days: " + dayOptions.size());

		// ================= YEAR DROPDOWN =================

		WebElement yearDropdown = driver.findElement(By.id("year"));
		Select year = new Select(yearDropdown);

		// Select using different methods
		year.selectByIndex(10);
		System.out.println("Selected by Index (Year): " + year.getFirstSelectedOption().getText());

		year.selectByValue("2000");
		System.out.println("Selected by Value (Year): " + year.getFirstSelectedOption().getText());

		year.selectByVisibleText("1998");
		System.out.println("Selected by Visible Text (Year): " + year.getFirstSelectedOption().getText());

		// Print all values of Year dropdown
		List<WebElement> yearOptions = year.getOptions();
		System.out.println("All Year Values:");
		for (WebElement option : yearOptions) {
			System.out.println(option.getText());
		}

		// Count Year items
		System.out.println("Total number of Years: " + yearOptions.size());
	}

	@AfterTest
	    public void tearDown() {

	        driver.quit();
	    }
}}
