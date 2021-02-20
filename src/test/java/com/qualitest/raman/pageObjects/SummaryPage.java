package com.qualitest.raman.pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SummaryPage extends InitPage {

	public SummaryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="cart_title")
	private WebElement cartSummary;
	
	@FindBy(xpath="//*[@id='HOOK_SHOPPING_CART']/following::span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;
	
	@FindBy(className="cart_navigation clearfix")
	private WebElement navigation;
	
	@FindBy(name="processAddress")
	private WebElement addressAndClickOnProceed;
	
	@FindBy(id="cgv")
	private WebElement checkTerms;
	
	@FindBy(name="processCarrier")
	private WebElement carrierAndClickOnProceed;
	
	
	@FindBy(className="cheque")
	private WebElement payByCheque;
	
	@FindBy(xpath="//span[text()='I confirm my order']")
	private WebElement confirmOrder;
	
	@FindBy(xpath="//p[contains(text(),'Your order on My Store is complete.')]")
	private WebElement confirmationMessage;
	
	
	@FindBy(xpath="//br[3]")
	private WebElement orderReference;
	
	
	@FindBy(xpath="//*[text()='Back to orders']")
	private WebElement backToOrder;
	
	
	public void verifyCartSummaryPageIsDisplayed(){
		wait.until(ExpectedConditions.titleIs("Order - My Store"));
	}
	
	
	public void clickOnProceedToCheckout() {
		this.proceedToCheckOut.click();
		wait.until(ExpectedConditions.elementToBeClickable(addressAndClickOnProceed));
		this.addressAndClickOnProceed.click();
		wait.until(ExpectedConditions.elementToBeClickable(carrierAndClickOnProceed));
		this.checkTerms.click();
		this.carrierAndClickOnProceed.click();
		this.payByCheque.click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
		this.confirmOrder.click();
	}
	
	public void validateOrderIsSuccessful() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'Your order on My Store is complete.')]")));
		assertEquals("Your order on My Store is complete.", this.confirmationMessage.getText());
	}
	
	public OrderHistoryPage clickOnBackToOrders() {
		this.backToOrder.click();
		return new OrderHistoryPage(driver);
	}
		
}
