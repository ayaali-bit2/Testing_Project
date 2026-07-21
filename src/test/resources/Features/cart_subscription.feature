Feature: Subscribe from the cart section
  In order to receive updates about the cart
  As a shopper
  I want to submit my email from the cart subscription panel.

  Scenario: Subscribe using the cart subscription field
    Given the user is on the automationexercise.com home page
    When they open the cart panel or click on the cart button
    And they focus on the newsletter input
    And they enter "ayaali@gmail.com"
    And they submit the subscription
    Then the subscription confirmation area should be displayed
