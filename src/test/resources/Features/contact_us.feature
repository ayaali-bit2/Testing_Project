Feature: Contact Us form submission
  In order to communicate with the site owners
  As a visitor
  I want to fill and submit the Contact Us form.

  Scenario: Send a message through the Contact Us page
    Given the visitor is on the automationexercise.com home page
    When they click the Contact Us button
    And the "Get In Touch" section is visible
    And they enter "aya" as the name
    And they enter "ayaali@gmail.com" as the email
    And they enter "bla bla" as the subject
    And they enter "brjhbvejhvbejhbvjbvjhbvjhbjh" as the message
    And they attach the file "C:/Users/Aya Ali/OneDrive/Desktop/Ahmed-Ali final-cv.pdf"
    And they submit the form
    Then an alert should appear confirming submission
    And the success message should be displayed
    When they go back to the home page
    Then the homepage hero section should be visible again
