Feature: Register with an existing email
  In order to prevent duplicate accounts
  As a prospective user
  I want to see a validation message if the account already exists.

  Scenario: Attempt to register with an existing account
    Given the user is on the automationexercise.com home page
    When they click Sign Up / Login
    And the New User Signup form is visible
    And they type "Aya" into the name field
    And they type "ayaali@gmail.com" into the email field
    And they click the Sign Up button
    Then the page should show that the account already exists
