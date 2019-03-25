package com.stepdefinations;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.base.TestBase;
import com.listeners.ExtentReportListener;
import com.runners.HooksHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDefination extends ExtentReportListener{

	Properties prop;
	WebDriver driver;
	TestBase testBase;
	Logger log = Logger.getLogger(LoginStepDefination.class);
	

	public LoginStepDefination() {
		driver = HooksHelper.driver;	
	}

	@Given("^Enter the url of ACE LMS$")
    public void enter_the_url_of_ace_lms() throws Throwable {

		testBase = new TestBase();
		prop = testBase.readPropFile();
		log.info("***************Read Prop File***************" + prop);

		ExtentTest logInfo=null;
		try {
			
			test = extent.createTest(Feature.class, "ACE LMS Login Logout Feature");							
			test = test.createNode(Scenario.class, "Login in ACE LMS and Logout");						
			logInfo=test.createNode(new GherkinKeyword("Given"), "enter_the_url_of_ace_lms");
			driver.manage().window().fullscreen();
			
			System.out.println(prop.getProperty("url"));
			log.info("***************Load URL in browser***************");
			driver.get(prop.getProperty("url"));
			log.info("**********On the Login Page**********");
			
			logInfo.pass("Opened chrome browser and entered url");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));			
			
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			testStepHandle("FAIL",driver,logInfo,e);			
		}		
	}

	@Then("^Enter the username and password and click on login button$")
    public void enter_the_username_and_password_and_click_on_login_button() throws Throwable {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "enter_the_username_and_password_and_click_on_login_button");
			log.info("***************Enter the username***************");
			driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
			log.info("***************Enter the password***************");
			driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
			log.info("***************Enter the login button***************");
			driver.findElement(By.id("loginbtn")).click();
			
			
			
			logInfo.pass("Enter the username and password and click on loginbutton");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));			
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}		
	}

	@Then("^Logout from the account$")
    public void logout_from_the_account() throws Throwable {
		
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "logout_from_the_account");
			String title = driver.getTitle();
			assertEquals(title, "Dashboard");
			log.info("***************Print the title***************");
			Thread.sleep(5000);
			driver.findElement(By.id("dropdown-1")).click();
			driver.findElement(By.id("actionmenuaction-9")).click();
			
			logInfo.pass("Logout from the account");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));			
			
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}		
	}
	
	
}


