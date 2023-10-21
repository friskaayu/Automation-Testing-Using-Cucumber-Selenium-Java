Feature: Sorting Product

  Scenario: Sort products by price high to low
    Given User should success login in to saucedemo web
    When  User click dropdown icon in top right of page
    And   User choose price high to low
    Then  List products on the home page will be sorted based on prices high to low