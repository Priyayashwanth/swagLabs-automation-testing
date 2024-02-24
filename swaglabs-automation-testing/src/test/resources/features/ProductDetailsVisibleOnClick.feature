Feature: Visibility of Product details on click

  Scenario: Product details are displayed when a user click on a specific product
    Given I access the swag labs login page
    When I enter username
    And I enter password
    And I click on login button
    And I click on a product
    Then I should get the details about that product
