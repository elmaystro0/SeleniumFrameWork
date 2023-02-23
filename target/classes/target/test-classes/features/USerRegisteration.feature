Feature: User Registeration
	I want to check that the User Can Register in out E-Commerce Website
	
	Scenario: User Registeration
	Given The User is in the home page
	When I click on Register Link
	And I entere "<FirstName>", "<LastName>", "<Email>", "<Password>"
	Then The Registeration page displayed Successfully
	
	Examples:
	| FirstName | LastName | Email | Password |
	| Mohamed | Salama | test08@testing.com | 123456789|
	| Ahmed | Salah | test09@testing.com | 123456789|
