Feature: End To End Test
I want to Register, Login, search for product, then and to the Cart

Scenario: Customer can Add An Item to the shopping Cart by searching in the Website

Given User is on home page
When Customer will press on register link and enter "<FirstName>", "<LastName>", "<Email>", "<Password>"
And Customer will login Using the data "<Email>", "<Password>"
And Customer will Search For Prouct "<ProductName>"
And Customer will add to Shopping Cart
Then Item will be displayed in the shopping Cart

Examples: 
| FirstName | LastName | Email | Password | ProductName |
| Mohamed | Salama | testa01@tester.com | 123456789 | Apple MacBook Pro 13-inch |