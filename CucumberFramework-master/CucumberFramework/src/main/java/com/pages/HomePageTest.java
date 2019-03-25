package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageTest{
	
	WebDriver driver;
	
	@FindBy(id="dropdown-1")
	WebElement SelectDropDown;
	
	@FindBy(id="actionmenuaction-9")
	WebElement Logout;
	
	public HomePageTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Logout() throws InterruptedException{
		SelectDropDown.click();
		Thread.sleep(5000);
		Logout.click();
	}
	
	public String HomePageTitle(){
		return driver.getTitle();
	}
}
