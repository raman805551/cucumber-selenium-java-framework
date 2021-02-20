package com.qualitest.raman.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends InitPage {
		
	public LandingPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	private WebElement signInButton;
	
	@FindBy(className="account")
	private WebElement account;
	
	public SignInPage clickOnSignInButton() {
		this.signInButton.click();
		wait.until(ExpectedConditions.titleIs("Login - My Store"));
		return new SignInPage(driver);
	}
	
	public MyAccountPage clickOnAccount() {
		this.account.click();
		return new MyAccountPage(driver);
	}

}
