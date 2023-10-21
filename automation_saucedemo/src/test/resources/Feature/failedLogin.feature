Feature: Failed Login

  Scenario: Login with invalid  usernames and passwords
    Given User go to saucedemo login page
    When  User input the invalid username
    And   User input the invalid Password
    And   Click the login button
    Then  User should not navigate to saucedemo home page