Feature: Validate E-commerce Web page
	This feature demonstrates how to validate the checkout product journey
	and also validates personal information update

	Background:
		Given I launch the application url
		When I click on sign in button
		And I enter user name and password
		Then I should login successfully

	Scenario Outline: Validate that user is able to order product and verify same in order history

		Given I search for the products "<productName>"
		And I navigate to the search results pages
		When I add the items "<productName>" to cart
		And I click on proceed to checkout
		Then I should navigate to cart summary page
		When I proceed to check out the "<productName>"
		Then I should order the "<productName>" successfully
		When I click on back to orders
		Then I can see order history is displayed
		And validate order reference is displayed

		Examples:
			| productName    |
			| t-shirt	     |


	Scenario Outline: Validate user is able to update the personal information

		Given I click on personal info
		When I update the first name "<firstName>"
		And I update the current password "<password>" new passowrd "<newPassword>"
		And I click on save button
		Then updates should be successful

		Examples:
			| password         | newPassword      | firstName |
			| Automation01	   | Automation01     | user      |
	