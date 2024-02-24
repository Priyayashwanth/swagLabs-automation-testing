Feature: Successful Login

  Scenario: Login successfully using valid username and password
    Given I access the swag labs login page
    When I enter username
    And I enter password
    And I click on login button
    Then I should be presented with products list
