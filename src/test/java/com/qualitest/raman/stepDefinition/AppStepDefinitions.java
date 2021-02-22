package com.qualitest.raman.stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qualitest.raman.pageObjects.UserSummaryPage;
import com.qualitest.raman.pageObjects.LandingPage;
import com.qualitest.raman.pageObjects.MyAccountPage;
import com.qualitest.raman.pageObjects.HistoryPage;
import com.qualitest.raman.pageObjects.ResultsPage;
import com.qualitest.raman.pageObjects.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AppStepDefinitions extends SetUp {

	private WebDriverWait wait = new WebDriverWait(driver, 60);
	private LandingPage launchPage;
	private SignInPage signInPage;
	private MyAccountPage myAcccountPage;
	private ResultsPage resultsPage;
	private UserSummaryPage cartUserSummaryPage;
	private HistoryPage historyPage;

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
		signInPage = launchPage.clickOnSigninButton();
	}

	@When("I enter user name and password")
	public void enter_the_and()  {
		myAcccountPage = signInPage.enterTheCredential(prop.getProperty("userName"), prop.getProperty("password"));
	}

	@Then("I should login successfully")
	public void i_should_login_successfully() {
		myAcccountPage.validateMyAccountPage();
	}

	@Given("I search for the products {string}")
	public void i_search_for_the_product(String productName) {
		resultsPage = myAcccountPage.searchForProduct(productName);
	}

	@Then("I navigate to the search results pages")
	public void i_should_navigate_to_the_search_results_page() {
		resultsPage.verifySearchResultsPageIsLoaded();
	}

	@When("I add the items \"t-shirt\" to cart")
	public void i_add_the_t_shirt_to_cart() {
		resultsPage.clickOnAddtoCartButtons();
	}

	@When("I click on proceed to checkout")
	public void i_click_on_proceed_to_check_out() {
		cartUserSummaryPage = resultsPage.clickOnProceedCheckout();
	}

	@Then("I should navigate to cart summary page")
	public void i_should_navigate_to_the_cart_summary_page() {
		cartUserSummaryPage.verifyCartSummaryPageIsDisplayed();
	}

	@When("I proceed to check out the {string}")
	public void i_proceed_to_checkout_the(String productName) {
		cartUserSummaryPage.clickOnProceed();
	}

	@Then("I should order the {string} successfully")
	public void i_should_be_able_to_order_the_successfully(String string) {
		cartUserSummaryPage.validateOrder();
	}

	@When("I click on back to orders")
	public void i_click_on_back_orders() {
		historyPage = cartUserSummaryPage.clickOnBackToOrder();
	}

	@Then("I can see order history is displayed")
	public void order_history_should_be_displayed() {
		historyPage.valiateOrderHistoryPageIsDisplayed();
	}

	@Then("validate order reference is displayed")
	public void validate_order_reference_is_displayed_in_order_history() {
		historyPage.verifyOrdersAreDisplayed();
	}


	@When("I click on personal info")
	public void i_click_on_personal_information() {
		myAcccountPage.clickOnPersonalInfo();

	}

	@When("I update the first name {string}")
	public void i_update_the_first_name_as(String newName) {
		myAcccountPage.updateFirstName(newName);
	}

	@When("I update the current password {string} new passowrd {string}")
	public void i_update_the_current_password_and_new_passowrd(String oldPassword, String newPassword) {
		myAcccountPage.updatePassword(oldPassword, newPassword);
	}

	@When("I click on save button")
	public void i_click_save_button() {
		myAcccountPage.clickSave();
	}

	@Then("updates should be successful")
	public void update_should_be_successful() {
		myAcccountPage.validateUpdate();
	}
}
