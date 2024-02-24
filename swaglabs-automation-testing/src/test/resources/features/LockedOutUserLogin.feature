Feature: Locked out user login denial

  Scenario: Login fails when a locked out user tries to login
    Given I access the swag labs login page
    When I enter a locked out username
    And I enter password
    And I click on login button
    Then I get an error message for locked out user
