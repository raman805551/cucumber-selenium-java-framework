package com.qualitest.raman.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends InitPage {

	public ResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="selectProductSort")
	private WebElement sortBy;

	@FindBy(className="product_img_link")
	private List<WebElement> productsList;

	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCarts;

	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedCheckOut;

	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement products;

	public void verifySearchResultsPageIsLoaded() {
		wait.until(ExpectedConditions.visibilityOfAllElements(productsList));
	}

	public void clickOnAddtoCartButtons() {
		Actions action = new Actions(driver);
		action.moveToElement(products).build().perform();
		this.addToCarts.click();
	}

	public UserSummaryPage clickOnProceedCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(proceedCheckOut));
		this.proceedCheckOut.click();
		return new UserSummaryPage(driver);
	}
}
