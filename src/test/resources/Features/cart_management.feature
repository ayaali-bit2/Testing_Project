Feature: Manage cart contents
  In order to keep track of purchases
  As a shopper
  I want to add items to the cart, verify them, and be able to remove them.

  Scenario: Verify product details after adding to the cart
    Given the user is on the automationexercise.com home page
    When they open the first product's detail page
    And they add that product to the cart
    And they open the cart view
    Then the cart should show the added product with its details

  Scenario: Remove a product from the cart
    Given the user is on the automationexercise.com home page
    When they choose a product from the home page
    And they go to the cart page
    Then the cart page header should be displayed
    When they delete the product from the cart
    Then the cart should display that it is empty
