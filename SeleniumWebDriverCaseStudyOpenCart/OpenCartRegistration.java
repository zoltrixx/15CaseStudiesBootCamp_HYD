package com.advanceselenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration; 

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartRegistration {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://demo.opencart.com/");
	}

	@Test
	public void registerUser() throws IOException {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Your Store";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title Verified Successfully");
		} else {
			System.out.println("Title Verification Failed");
		}

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		String registerText = driver.findElement(By.xpath("//h1")).getText();
		if (registerText.equals("Register Account")) {
			System.out.println("Register Account Text Verified");
		} else {
			System.out.println("Register Account Text Verification Failed");
		}

		File src = new File("C:\\CoforgeBootCampTesting\\ExternalDocuments\\UserDetails.xls");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = sheet.getLastRowNum();

		for (int i = 1; i <= rows; i++) {
			String firstName = sheet.getRow(i).getCell(0).getStringCellValue();
			String lastName = sheet.getRow(i).getCell(1).getStringCellValue();
			String email = sheet.getRow(i).getCell(2).getStringCellValue();
			String password = sheet.getRow(i).getCell(3).getStringCellValue();
			String confirmPassword = sheet.getRow(i).getCell(4).getStringCellValue();

			driver.findElement(By.id("input-firstname")).sendKeys(firstName);
			driver.findElement(By.id("input-lastname")).sendKeys(lastName);
			driver.findElement(By.id("input-email")).sendKeys(email);
			driver.findElement(By.id("input-password")).sendKeys(password);
			driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);

			driver.findElement(By.xpath("//input[@name='agree']")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();

			System.out.println("Registration Attempted for : " + email);
			break;
		}

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
