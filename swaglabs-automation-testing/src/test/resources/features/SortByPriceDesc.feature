Feature: Sort inventory by price in descending order

  Scenario: Login to swag labs and sort the inventory by price in descending order
    Given I access the swag labs login page
    When I enter username
    And I enter password
    And I click on login button
    And I click on sort
    And I select high to low
    Then Price of items should be in descending order
