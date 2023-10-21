Feature: Logout
  Scenario: Logout from saucedemo website
    Given User login to saucedemo website
    And   User should navigate to left sidebar
    When  User click logout button
    Then  User back to saucedemo website login page