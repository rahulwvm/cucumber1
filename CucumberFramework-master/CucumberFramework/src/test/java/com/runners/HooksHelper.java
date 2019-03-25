package com.runners;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.listeners.ExtentReportListener;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksHelper {
	TestBase testBase;
	public static WebDriver driver;
	Properties prop;
	Logger log = Logger.getLogger(HooksHelper.class);

	@Before
	public void setUp(){
		testBase = new TestBase();
		prop = testBase.readPropFile();
		log.info("***************Read Prop File***************");
		String BrowserName = prop.getProperty("browser");
		driver = testBase.launchBrowser(BrowserName);
		
		ExtentReportListener.setUp();
	}

	@After
	public void tearDown(){
		driver.quit();
		log.info("***************Closing Browser***************");
		ExtentReportListener.extent.flush();
	}
}
