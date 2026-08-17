Feature: Login feature in automation exercise project

#  Scenario: Successful Login with Valid Credentials
#    Given User is on home page login
#    When user click signUpOrLogIn button login
#    And enter correct email
#    And enter correct password
#    Then click on login button
#


  Scenario: failed Login with invalid credentials
    Given User is on home page login
    When user click signUpOrLogIn button login
    And enter incorrect email
    And enter incorrect password
    And click on login button
    Then check Invalid Messsage
