Feature: Access the Test Cases page
  In order to explore the test cases
  As a curious visitor
  I want to navigate to the Test Cases page and see its content.

  Scenario: Open the Test Cases page from the home page
    Given the user is on the automationexercise.com home page
    When they click the Test Cases navigation link
    Then the Test Cases page should load successfully
    And the "Test Cases" heading should be visible
