Feature: Login to saucedemo website

  Scenario Outline: Check the login functionality with accepted usernames and passwords
    Given User should navigate to saucedemo website
    When  User input username as <username> and password as <password>
    And   User should click the login button
    Then  User will be navigate to saucedemo home page

    Examples:
      | username                  | password       |
      | "standard_user"           | "secret_sauce" |
      | "locked_out_user"         | "secret_sauce" |
      | "problem_user"            | "secret_sauce" |
      | "performance_glitch_user" | "secret_sauce" |
      | "error_user"              | "secret_sauce" |
      | "visual_user"             | "secret_sauce" |