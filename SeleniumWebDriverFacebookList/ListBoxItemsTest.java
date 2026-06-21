package com.ListBoxItems;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ListBoxItemsTest {
	
	@Test
	public void handleDropDown() {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.facebook.com/campaign/landing.php");
		
		Select date = new Select(driver.findElement(By.id("day")));
		date.selectByIndex(4);
		String selectedDate = date.getFirstSelectedOption().getText();
		System.out.println("Selected Date = " + selectedDate);
		Select month = new Select(driver.findElement(By.id("month")));

		int currentMonth = java.time.LocalDate.now().getMonthValue();
		month.selectByIndex(currentMonth - 1);

		String selectedMonth = month.getFirstSelectedOption().getText();
		System.out.println("Current Month = " + selectedMonth);
		
		Select year = new Select(driver.findElement(By.id("year")));

		int previousYear = java.time.LocalDate.now().getYear() - 1;
		year.selectByVisibleText(String.valueOf(previousYear));

		String selectedYear = year.getFirstSelectedOption().getText();
	    System.out.println("Previous Year = " + selectedYear);

		driver.quit();
	}

}
