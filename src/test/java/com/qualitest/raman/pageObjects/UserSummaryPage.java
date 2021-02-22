package com.qualitest.raman.pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserSummaryPage extends InitPage {

	public UserSummaryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="cart_title")
	private WebElement cartSummaryTitle;

	@FindBy(xpath="//*[@id='HOOK_SHOPPING_CART']/following::span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedCheckOut;

	@FindBy(className="cart_navigation clearfix")
	private WebElement navigations;

	@FindBy(name="processAddress")
	private WebElement addressAndClickProceed;

	@FindBy(id="cgv")
	private WebElement checkTerm;

	@FindBy(name="processCarrier")
	private WebElement carrierAndClickProceed;


	@FindBy(className="cheque")
	private WebElement cheque;

	@FindBy(xpath="//span[text()='I confirm my order']")
	private WebElement confirmOrders;

	@FindBy(xpath="//p[contains(text(),'Your order on My Store is complete.')]")
	private WebElement confirmationMessage;


	@FindBy(xpath="//br[3]")
	private WebElement orderReference;


	@FindBy(xpath="//*[text()='Back to orders']")
	private WebElement backToOrder;


	public void verifyCartSummaryPageIsDisplayed(){
		wait.until(ExpectedConditions.titleIs("Order - My Store"));
	}


	public void clickOnProceed() {
		this.proceedCheckOut.click();
		wait.until(ExpectedConditions.elementToBeClickable(addressAndClickProceed));
		this.addressAndClickProceed.click();
		wait.until(ExpectedConditions.elementToBeClickable(carrierAndClickProceed));
		this.checkTerm.click();
		this.carrierAndClickProceed.click();
		this.cheque.click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrders));
		this.confirmOrders.click();
	}

	public void validateOrder() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'Your order on My Store is complete.')]")));
		assertEquals("Your order on My Store is complete.", this.confirmationMessage.getText());
	}

	public HistoryPage clickOnBackToOrder() {
		this.backToOrder.click();
		return new HistoryPage(driver);
	}

}
