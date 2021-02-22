package com.qualitest.raman.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends InitPage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="search_query_top")
	private WebElement txtSearchBox;

	@FindBy(name="submit_search")
	private WebElement searchBtn;


	@FindBy(xpath="//span[text()='My personal information']")
	private WebElement personalInfo;


	@FindBy(id="firstname")
	private WebElement firstName;

	@FindBy(name="submitIdentity")
	private WebElement saveBtn;

	@FindBy(id="old_passwd")
	private WebElement oldPwd;

	@FindBy(id="passwd")
	private WebElement newPwd;

	@FindBy(id="confirmation")
	private WebElement confirmPwd;

	@FindBy(xpath="//p[contains(text(),'Your personal information has been successfully updated.')]")
	private WebElement updateConfirmationMessage;


	public void validateMyAccountPage() {
		wait.until(ExpectedConditions.titleIs("My account - My Store"));
	}

	public ResultsPage searchForProduct(String productName){
		this.txtSearchBox.sendKeys(productName);
		this.searchBtn.click();
		return new ResultsPage(driver);
	}

	public void clickOnPersonalInfo() {
		wait.until(ExpectedConditions.visibilityOf(personalInfo));
		this.personalInfo.click();
	}

	public void updateFirstName(String newName) {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		this.firstName.clear();
		this.firstName.sendKeys(newName);
	}

	public void updatePassword(String oldPassword, String newPassword) {
		this.oldPwd.sendKeys(oldPassword);
		this.newPwd.sendKeys(newPassword);
		this.confirmPwd.sendKeys(newPassword);
	}

	public void clickSave() {
		this.saveBtn.click();
	}

	public void validateUpdate() {
		wait.until(ExpectedConditions.visibilityOf(updateConfirmationMessage));
	}
}
