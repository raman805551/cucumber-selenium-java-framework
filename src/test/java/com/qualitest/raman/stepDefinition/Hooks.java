package com.qualitest.raman.stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.qualitest.raman.stepDefinition.SetUp;
import org.openqa.selenium.WebDriver;

import com.qualitest.raman.utils.TestUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	SetUp setUp = new SetUp();
	WebDriver driver;
	
	@Before
	public void setUpDriver() {		
		Properties prop = null;
		try {
			InputStream input = new FileInputStream("./src/test/resources/TestData.properties");
			prop = new Properties();
			prop.load(input);
        } catch (IOException io) {
            io.printStackTrace();
        }
		TestUtils testUtils = new TestUtils(prop);
		driver = testUtils.invokeDriver();
		setUp.setDriver(driver);
		setUp.setProp(prop);
	}
	
	@After
	public void close() {
		driver.quit();
	}
}
