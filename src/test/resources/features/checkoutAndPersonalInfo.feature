Feature: Validate E-commerce Web page
This feature demonstrates how to validate the checkout product journey
and also validates personal information update

	Background:
		Given I launch the application url
		When I click on sign in button
		And I enter user name and password
		Then I should login successfully

Scenario Outline: Validate that user is able to order product and verify same in order history

Given I search for the product "<productName>"
And I navigate to the search results page
When I add the"<productName>" to cart
And I click on proceed to check out
Then I should navigate to the cart summary page
When I proceed to checkout the "<productName>"
Then I should be able to order the "<productName>" successfully
When I click on back orders
Then order history should be displayed
And validate order reference is displayed in order history

Examples:
	| productName    |
	| t-shirt	     |
	
	
Scenario Outline: Validate user is able to update the personal information

Given I click on personal information
When I update the first name as "<firstName>"
And I update the current password "<password>" and new passowrd "<newPassword>"
And I click save button
Then update should be successful

Examples:
	| password         | newPassword      | firstName |
	| Automation01	   | Automation01     | user      |
	