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
	private WebElement searchBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	
	@FindBy(xpath="//span[text()='My personal information']")
	private WebElement personalInformation;
	
	
	@FindBy(id="firstname")
	private WebElement firstName;
	
	@FindBy(name="submitIdentity")
	private WebElement save;

	@FindBy(id="old_passwd")
	private WebElement oldPassword;
	
	@FindBy(id="passwd")
	private WebElement newPassword;
	
	
	@FindBy(id="confirmation")
	private WebElement confirmPassword;
	
	
	
	@FindBy(xpath="//p[contains(text(),'Your personal information has been successfully updated.')]")
	private WebElement updateConfirmationMessage;
	
	
	public void validateMyAccountPageIsDisplayed() {
		wait.until(ExpectedConditions.titleIs("My account - My Store"));
	}
	
	public SearchResultsPage searchForTheProduct(String productName){
		this.searchBox.sendKeys(productName);
		this.searchButton.click();
		return new SearchResultsPage(driver);
	}
	
	public void clickOnPersonalInformation() {
		wait.until(ExpectedConditions.visibilityOf(personalInformation));
		this.personalInformation.click();
	}
	
	public void updateFirstName(String newName) {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		this.firstName.clear();
		this.firstName.sendKeys(newName);
	}
	
	public void updatePassword(String oldPassword, String newPassword) {
		this.oldPassword.sendKeys(oldPassword);
		this.newPassword.sendKeys(newPassword);
		this.confirmPassword.sendKeys(newPassword);
	}
	
	public void clickOnSave() {
		this.save.click();
	}
	
	public void validateUpdateIsSuccessful() {
		wait.until(ExpectedConditions.visibilityOf(updateConfirmationMessage));
	}
}
