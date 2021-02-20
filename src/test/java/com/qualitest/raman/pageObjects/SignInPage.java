package com.qualitest.raman.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends InitPage {

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id="email")
	private WebElement emailText;
	
	@FindBy(id="passwd")
	private WebElement passwordText;
	
	@FindBy(id="SubmitLogin")
	private WebElement submitButton;
	
	
	public MyAccountPage enterTheCredentials(String userName, String password) {
		this.emailText.sendKeys(userName);
		this.passwordText.sendKeys(password);
		this.submitButton.click();
		return new MyAccountPage(driver);
	}
	
}
