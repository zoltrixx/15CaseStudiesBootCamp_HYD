package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[@id='username-label']")
	WebElement email;
	
	@FindBy(xpath="//label[@id='password-label']")
	WebElement password;
	
	@FindBy(xpath="//button[@name='action']")
	WebElement signin;
	
	public void Email(String user) {
		email.sendKeys(user);
	}
	public void Password(String pass) {
		password.sendKeys(pass);
	}
	public void SignIn() {
		signin.click();
	}
	
}
