Feature: Checkout fails because of no user information

  Scenario: Checkout fails when user tries to checkout without providing user information
    Given I access the swag labs login page
    When I enter username
    And I enter password
    And I click on login button
    And I add an item to cart
    And I click on cart icon
    And I click on checkout
    And I click on continue
    Then I should get an error message
