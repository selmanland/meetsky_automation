@wip
Feature: Only authorized users should be able to login to the application


  Scenario: the user logs in with valid credentials
    Given the user is on the login page
    When the user enters credentials
    Then the account summary page should be displayed


  Scenario: the user logs in with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials "" "password"
    Then error message should be displayed