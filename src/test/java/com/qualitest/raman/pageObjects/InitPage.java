package com.qualitest.raman.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public InitPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
	}

}
