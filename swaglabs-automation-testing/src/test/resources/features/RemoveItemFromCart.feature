Feature: Remove item from Shopping Cart

  Scenario: User will login, add items to the cart and then go to the cart and remove one item
    Given I access the swag labs login page
    When I enter username
    And I enter password
    And I click on login button
    And I add items to the cart
    And I click on cart icon
    And I click the remove button for a specific item
    Then the item should be immediately removed from the cart
    And cart count should update accordingly
