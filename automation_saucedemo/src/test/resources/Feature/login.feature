Feature: Login

  Scenario: Login with valid usernames and passwords
    Given User should navigate to saucedemo login page
    When  User input the username
    And   User input the  Password
    And   User click the login button
    Then  User should navigate to saucedemo home page
