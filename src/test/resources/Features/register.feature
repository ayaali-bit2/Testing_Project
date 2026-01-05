Feature: Register feature in automation exercise project

#  Scenario: Successful Register with Valid Credentials
#    Given User is on home page
#    When user click signUpOrLogIn button
#    And enter username
#    And enter email
#    And click on signUp button
#    And enter title
#    And enter password
#    And enter day birth
#    And enter month birth
#    And enter year birth
#    And check newsletter
#    And check recieve specials offers
#    And set first name
#    And set last name
#    And set company name
#    And set first address
#    And set seconed address
#    And set country name
#    And set state name
#    And set city name
#    And set zipcode
#    And set mobile number
#    And click on create on create button
#    Then verify account is created


    Scenario: register with existing account
      Given User is on home page
      When user click signUpOrLogIn button
      When enter username
      When enter email
      And click on signUp button
      Then check Accounte is Existed Message
