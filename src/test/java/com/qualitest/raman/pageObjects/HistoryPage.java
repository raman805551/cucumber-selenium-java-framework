package com.qualitest.raman.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HistoryPage extends InitPage {

	public HistoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className="color-myaccount")
	private List<WebElement> ordersList;

	public void valiateOrderHistoryPageIsDisplayed() {
		wait.until(ExpectedConditions.titleIs("Order history - My Store"));
	}

	public void verifyOrdersAreDisplayed() {
		wait.until(ExpectedConditions.visibilityOfAllElements(ordersList));
	}

}
