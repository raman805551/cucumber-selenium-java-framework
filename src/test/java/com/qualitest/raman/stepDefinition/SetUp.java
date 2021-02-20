package com.qualitest.raman.stepDefinition;

import org.openqa.selenium.WebDriver;

import java.util.Properties;


public class SetUp {
	
	protected static WebDriver driver;
	protected static Properties prop;

	public  Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		SetUp.prop = prop;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		SetUp.driver = driver;
	}
	
	

}
