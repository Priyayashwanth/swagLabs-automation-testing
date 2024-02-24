Feature: Logout Successfully

  Scenario: User will login and logout of the website successfully
    Given I access the swag labs login page
    When I enter username
    And I enter password
    And I click on login button
    And I click on hamburger menu
    And I click on logout
    Then I should be back to the login page
