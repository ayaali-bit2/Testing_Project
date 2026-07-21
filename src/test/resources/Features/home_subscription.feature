Feature: Subscribe from the home page newsletter
  In order to stay informed about offers
  As a visitor
  I want to submit my email through the homepage subscription section.

  Scenario: Submit email in the homepage subscription form
    Given the user is on the automationexercise.com home page
    When they scroll to or reveal the footer subscription area
    And they type "aya@gmail.com" into the newsletter field
    And they click the submit button
    Then the subscription confirmation message should be visible
