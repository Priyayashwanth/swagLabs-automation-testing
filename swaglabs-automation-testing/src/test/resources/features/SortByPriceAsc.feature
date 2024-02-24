Feature: Sort inventory by price in ascending order

  Scenario: Login to swag labs and sort the inventory by price in ascending order
    Given I access the swag labs login page
    When I enter username
    And I enter password
    And I click on login button
    And I click on sort
    And I select low to high
    Then Price of items should be in ascending order
