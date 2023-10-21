Feature: Order
  Scenario: User successfully complete the order
    Given User open the SauceDemo website
    When  User log in as a standard user
    And   User select a product named Sauce Labs Backpack
    Then  User should see the product details matching Sauce Labs Backpack
    And   User add the product to the cart
    And   User go to the cart
    And   User proceed to checkout
    And   User enter the following checkout information:
    And   User continue with the checkout
    And   User complete the order
    Then  User should see a confirmation message THANK YOU FOR YOUR ORDER