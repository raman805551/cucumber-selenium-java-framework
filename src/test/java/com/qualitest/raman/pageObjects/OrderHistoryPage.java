package com.qualitest.raman.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderHistoryPage extends InitPage {

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className="color-myaccount")
	private List<WebElement> orders;
	
	public void valiateOrderHistoryPageIsDisplayed() {
		wait.until(ExpectedConditions.titleIs("Order history - My Store"));
	}
	
	public void verifyOrdersAreDisplayed() {
		wait.until(ExpectedConditions.visibilityOfAllElements(orders));
	}

}
