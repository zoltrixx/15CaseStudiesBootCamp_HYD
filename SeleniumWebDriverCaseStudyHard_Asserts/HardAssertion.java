package com.assertionsdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HardAssertion {
	WebDriver driver;
	String url="https://www.easemytrip.com/flights";
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@Test
	public void validateAssertions() {
		String String1="MyAccount";
		String String2="My Booking";
		
		Assert.assertEquals(String1,"MyAccount");
		System.out.println("assertEquals Passes");
		
		Assert.assertNotEquals(String1,"MyAccount");
		System.out.println("assertNotEquals Passes");
		
		Assert.assertTrue(String1.equals(String2));
		System.out.println("assertTrue Passes");
		
		Assert.assertFalse(String1.equals(String2));
		System.out.println("assertFalse Passes");
		
		String value=null;
		Assert.assertNull(value);
		System.out.println("assertNull Passes");
		
		Assert.assertNotNull(String1);
		System.out.println("assertNotNull Passes");
	}
}
