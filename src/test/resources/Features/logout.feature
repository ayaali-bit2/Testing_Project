Feature: Logout User
  Scenario: logout user from his account
    Given User is on home page logout
    When user click signUpOrLogIn button logout
    When enter correct email
    When enter correct password
    And click on login button logout
    Then click on logout button
