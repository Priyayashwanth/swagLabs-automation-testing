Feature: Navigate to About page

  Scenario: User is able to navigate to About page
    Given I access the swag labs login page
    When I enter username
    And I enter password
    And I click on login button
    And I click on hamburger menu
    And I click on About
    Then About page should be displayed
