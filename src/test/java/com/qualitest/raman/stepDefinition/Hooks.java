package com.qualitest.raman.stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qualitest.raman.utilities.TestUtilities;

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
		TestUtilities testUtilities = new TestUtilities(prop);
		driver = testUtilities.invokeDriver();
		setUp.setDriver(driver);
		setUp.setProp(prop);
	}
	
	@After
	public void close() {
		driver.quit();
	}
}
