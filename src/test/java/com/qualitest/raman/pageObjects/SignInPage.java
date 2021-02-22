package com.qualitest.raman.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends InitPage {

	public SignInPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id="email")
	private WebElement email;

	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement submitButton;


	public MyAccountPage enterTheCredential(String userName, String password) {
		this.email.sendKeys(userName);
		this.password.sendKeys(password);
		this.submitButton.click();
		return new MyAccountPage(driver);
	}

}
