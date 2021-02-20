package com.qualitest.raman.stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qualitest.raman.pageObjects.SummaryPage;
import com.qualitest.raman.pageObjects.LandingPage;
import com.qualitest.raman.pageObjects.MyAccountPage;
import com.qualitest.raman.pageObjects.OrderHistoryPage;
import com.qualitest.raman.pageObjects.SearchResultsPage;
import com.qualitest.raman.pageObjects.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AppStepDefinitions extends SetUp {
	
	private WebDriverWait wait = new WebDriverWait(driver, 60);
	private LandingPage launchPage;
	private SignInPage signInPage;
	private MyAccountPage myAcccountPage;
	private SearchResultsPage searchResultsPage;
	private SummaryPage cartSummaryPage;
	private OrderHistoryPage orderHistoryPage;
	
	@Given("I launch the application url")
	public void i_access_the_application_url() {
		System.out.println(prop.getProperty("appUrl"));
		driver.get(prop.getProperty("appUrl"));
		wait.until(ExpectedConditions.titleIs("My Store"));
	    String expTitle = driver.getTitle();
	    assertEquals(expTitle, "My Store");
	    launchPage = new LandingPage(driver);
	}
	
	@When("I click on sign in button")
	public void i_enter_click_on_sign_in_button() {
		signInPage = launchPage.clickOnSignInButton();    
	}

	@When("I enter user name and password")
	public void enter_the_and()  {
		myAcccountPage = signInPage.enterTheCredentials(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@Then("I should login successfully")
	public void i_should_login_successfully() {
		myAcccountPage.validateMyAccountPageIsDisplayed();
	}
	
	@Given("I search for the product {string}")
	public void i_search_for_the_product(String productName) {
		searchResultsPage = myAcccountPage.searchForTheProduct(productName);
	}

	@Then("I navigate to the search results page")
	public void i_should_navigate_to_the_search_results_page() {
		searchResultsPage.verifySearchResultsPageIsLoaded();
	}
	
	@When("I add the\"t-shirt\" to cart")
	public void i_add_the_t_shirt_to_cart() {
		 searchResultsPage.clickOnAddtoCartButton();
	}
	
	@When("I click on proceed to check out")
	public void i_click_on_proceed_to_check_out() {
		 cartSummaryPage = searchResultsPage.clickOnProceedToCheckout();
	}
	
	@Then("I should navigate to the cart summary page")
	public void i_should_navigate_to_the_cart_summary_page() {
		cartSummaryPage.verifyCartSummaryPageIsDisplayed();
	}
	
	@When("I proceed to checkout the {string}")
	public void i_proceed_to_checkout_the(String productName) {
		cartSummaryPage.clickOnProceedToCheckout();
	}
	
	@Then("I should be able to order the {string} successfully")
	public void i_should_be_able_to_order_the_successfully(String string) {
		cartSummaryPage.validateOrderIsSuccessful();
	}
	
	@When("I click on back orders")
	public void i_click_on_back_orders() {
		orderHistoryPage = cartSummaryPage.clickOnBackToOrders();
	}

	@Then("order history should be displayed")
	public void order_history_should_be_displayed() {
		orderHistoryPage.valiateOrderHistoryPageIsDisplayed();
	}
	
	@Then("validate order reference is displayed in order history")
	public void validate_order_reference_is_displayed_in_order_history() {
		orderHistoryPage.verifyOrdersAreDisplayed();
	}

	
	@When("I click on personal information")
	public void i_click_on_personal_information() {
		myAcccountPage.clickOnPersonalInformation();
	    
	}

	@When("I update the first name as {string}")
	public void i_update_the_first_name_as(String newName) {
		myAcccountPage.updateFirstName(newName);
	}
	@When("I update the current password {string} and new passowrd {string}")
	public void i_update_the_current_password_and_new_passowrd(String oldPassword, String newPassword) {
		myAcccountPage.updatePassword(oldPassword, newPassword);
	}
	@When("I click save button")
	public void i_click_save_button() {
		myAcccountPage.clickOnSave();
	}
	@Then("update should be successful")
	public void update_should_be_successful() {
		myAcccountPage.validateUpdateIsSuccessful();
	}
}
