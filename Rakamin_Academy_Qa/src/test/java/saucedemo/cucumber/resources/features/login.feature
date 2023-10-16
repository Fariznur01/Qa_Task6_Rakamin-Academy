Feature: Login to Sauce Demo
  In order to access the application,
  As a registered user,
  I want to be able to log in to the Sauce Demo website.

  Background:
    Given I am on the Sauce Demo login page

    @Regression @Positive
  Scenario: Successful Login
    When I enter a valid username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be logged in successfully

  @Regression @Negative
  Scenario: Failed Login with Invalid Credentials
    When I enter an invalid username "invalid_user" and password "invalid_password"
    And I click the login button
    Then I should see an error message

  @Regression @Negative
  Scenario: Failed Login with Empty Credentials
    When I leave the username and password fields empty
    And I click the login button
    Then I should see an error message

  @Regression @Negative
  Scenario: Failed Login with Locked Out User
    When I enter the username "locked_out_user" and password "secret_sauce"
    And I click the login button
    Then I should see an error message
