package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPageTest extends TestBase{
	
	WebDriver driver;
	HomePageTest homepage;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginbtn")
	WebElement loginbutton;
	
	public LoginPageTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePageTest Login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		return homepage;
	}
	
}
