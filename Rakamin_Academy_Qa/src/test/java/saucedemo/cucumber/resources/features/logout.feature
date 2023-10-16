Feature: Logout from Sauce Demo

  In order to log out from the application,
  As a registered user,
  I want to be able to log out from the Sauce Demo website.

  Background:
    Given I am on the Sauce Demo login page
    And I am logged in with valid credentials

  @Regression @Positive
  Scenario: Logout from the Application
    When I click tab menu
    And I click the logout button
    Then I should be logged out
