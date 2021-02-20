package com.qualitest.raman.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends InitPage {
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="selectProductSort")
	private WebElement sortByDropDown;
	
	@FindBy(className="product_img_link")
	private List<WebElement> productsList;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement product;
	
	public void verifySearchResultsPageIsLoaded() {
		wait.until(ExpectedConditions.visibilityOfAllElements(productsList));		
	}
	
	public void clickOnAddtoCartButton() {
		Actions action = new Actions(driver);
		action.moveToElement(product).build().perform();
		this.addToCart.click();	
	}
	
	public SummaryPage clickOnProceedToCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOut));
		this.proceedToCheckOut.click();
		return new SummaryPage(driver);
	}
}
