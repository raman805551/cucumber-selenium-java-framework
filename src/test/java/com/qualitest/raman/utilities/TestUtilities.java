package com.qualitest.raman.utilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUtilities {
	
	Properties prop;
	
	public TestUtilities(Properties prop){
		this.prop = prop;
	}
	
	public WebDriver invokeDriver() {
		WebDriver driver = null;
		String browserName = prop.getProperty("browser");
		switch(browserName.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver.path"));
				driver = new ChromeDriver();
				
			default:
					
		}
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
