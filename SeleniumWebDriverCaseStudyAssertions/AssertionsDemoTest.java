package com.SeleniumAssertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AssertionsDemoTest {

    WebDriver driver;
    String url = "https://www.easemytrip.com/";

    String String1 = "MyAccount";
    String String2 = "My Booking";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void assertionTest() throws Exception {

        // Wait to observe browser (optional)
        Thread.sleep(5000);

        // assertEquals
        Assert.assertEquals(String1, String2, "❌ Strings are NOT equal");

        // assertNotEquals
        Assert.assertNotEquals(String1, String2, "✅ Strings are equal (unexpected)");

        // assertTrue
        Assert.assertTrue(String1.equals("MyAccount"), "❌ Condition is false");

        // assertFalse
        Assert.assertFalse(String1.equals(String2), "❌ Condition is true");

        // assertNull
        String nullValue = null;
        Assert.assertNull(nullValue, "❌ Value is NOT NULL");

        // assertNotNull
        Assert.assertNotNull(String1, "❌ Value is NULL");

        System.out.println("✅ All Assertions Executed");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
