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
	private WebElement signIn;

	@FindBy(className="account")
	private WebElement accountButton;

	public SignInPage clickOnSigninButton() {
		this.signIn.click();
		wait.until(ExpectedConditions.titleIs("Login - My Store"));
		return new SignInPage(driver);
	}

}
