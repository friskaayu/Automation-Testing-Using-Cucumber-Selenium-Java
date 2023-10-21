Feature: Add To Cart

  Scenario: Add product to cart
    Given User success login in saucedemo web
    When  Click the Add to Cart button on the selected product
    And   User click icon cart in top right of page
    Then  On the cart page, the selected products will be displayed