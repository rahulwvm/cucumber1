package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utilities.Paths;

public class TestBase{

	public WebDriver driver;
	public Properties prop;
	Logger log = Logger.getLogger(TestBase.class);
	
	public Properties readPropFile() {
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream(Paths.CONFIG_PROPERTIES_FILE);
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public WebDriver launchBrowser(String BrowserName) {
		if (BrowserName.equals("chrome")) {
			log.info("===========Launch Chrome Browser===========");
			System.setProperty("webdriver.chrome.driver",
					Paths.CHROME_DRIVER);
			driver = new ChromeDriver();
		} else if (BrowserName.equals("firefox")) {
			log.info("===========Launch FF Browser===========");
			System.setProperty("webdriver.gecko.driver",
					Paths.GECKO_DRIVER_FF);
			driver = new FirefoxDriver();
		} else {
			System.out.println(BrowserName + ": is not correct or blank");
			try {
				throw new Exception("NO BROWSERFOUND EXCEPTION");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
	
}
