Feature: Register during the checkout flow
  In order to complete a purchase
  As a shopper without an account
  I want to register while checking out and finalize an order.

  Scenario: Create an account in checkout and place the order
    Given the shopper is on the automationexercise.com home page
    When they add the first product to the cart
    And they continue shopping
    And they add a second product to the cart
    And they go to the cart page
    Then the cart should show the added products
    When they proceed to checkout
    And they choose to register or login
    And they key in username "MODY" and email "mody2002@gmail.com"
    And they complete the registration form with title "Mr", password "123456789", birth date "7 May 2002", and enable newsletter and special offers
    And they fill their personal details with name "Mody Ali", company "Egypt", address "frehigknaagkn", address2 "jkejkebjkbk", country "bafjkvfjkab", state "cairo", city "gesr el suaz", zip "223344", and mobile "012334455"
    And they create the account
    Then the site should confirm the new user was created
    When they return to the cart page and proceed to checkout again
    And they verify the saved address details and the review your order section
    And they write "jrkgnerjknrjk" into the comment box
    And they place the order
    And they enter cardholder name "mody", card number "wekjerjkb", CVC "222", expiration "02/2024"
    And they confirm the payment
    Then the success message should be displayed
    When they delete the order
    Then the order deletion confirmation should be visible
