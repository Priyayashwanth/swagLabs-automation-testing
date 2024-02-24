Feature: Add items to shopping cart

  Scenario: User will login to swag labs and add items to cart
    Given I access the swag labs login page
    When I enter username
    And I enter password
    And I click on login button
    And I add an item to cart
    And I click on cart icon
    Then The items that I added should appear in the shopping cart
