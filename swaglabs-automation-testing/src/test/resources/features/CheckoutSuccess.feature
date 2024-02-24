Feature: Checkout Successfully

  Scenario: Login, add 2 products to shopping cart and checkout successfully
    Given I access the swag labs login page
    When I enter username
    And I enter password
    And I click on login button
    And I add 2 items to cart
    And I click on cart icon
    And I click on checkout
    And I enter first name
    And I enter last name
    And I enter postal code
    And I click on continue
    And I click on finish
    Then I should get a successful message
