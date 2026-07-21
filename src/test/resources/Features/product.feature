Feature: Explore the product catalogue
  In order to learn more about the available items
  As a shopper on automationexercise.com
  I want to browse the product listing and search for specific products.

  Scenario: Browse the product catalogue and inspect the first product
    Given the user is on the automationexercise.com home page
    When they click on the Products link in the header
    Then the products listing should be visible
    When they open the first product's detail view
    Then the product name should be "Blue Top"
    And the category should mention "Women > Tops"
    And the price should be "Rs. 500"
    And the availability, condition, and brand labels should be displayed

  Scenario: Search for an existing product and see related results
    Given the user is on the automationexercise.com home page
    When they navigate to the Products page
    And they type "Blue Top" into the search field
    And they submit the search
    Then the matching product results should appear with a heading for the search
    And the related search products section should remain visible
