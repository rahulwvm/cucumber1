package com.utilities;

public class Paths {

	public final static String CONFIG_PROPERTIES_FILE = System
			.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";

	public final static String GECKO_DRIVER_FF = System
			.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\drivers\\geckodriver.exe";

	public final static String CHROME_DRIVER = System
			.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\drivers\\chromedriver.exe";
	
	public final static String ScreenShots = System
			.getProperty("user.dir")
			+ "\\Images";
	
	public final static String ExtentReportLocation = System
			.getProperty("user.dir")
			+ "\\ExtentReport\\";
}
