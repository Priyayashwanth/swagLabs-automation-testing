Feature: Failed Login

  Scenario: Login fails due to incorrect password
    Given I access the swag labs login page
    When I enter username
    And I enter wrong password
    And I click on login button
    Then I get an error message for incorrect password
