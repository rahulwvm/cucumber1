package com.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features={"src/test/resources/com/features"},
		glue={"com.stepdefinations", "com.runners"},
		plugin={"pretty",
		   		"html:target/cucumber-html-report",
		   		"json:target/cucumber.json",},
		monochrome = true
		)

public class runnerTest extends AbstractTestNGCucumberTests {
		

}