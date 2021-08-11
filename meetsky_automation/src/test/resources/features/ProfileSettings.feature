Feature: As a user, I should be able to change profile info settings under the Profile module

  AC:
  Display personal info under Profile Settings page
  User can change any info under Profile Settings page

  @login
  Scenario: The user should change profile settings
    Given the user is on the login page
    When the user enters Profile Settings
    And the user change profile settings
    Then the user verify that the modification as follows

      | Selman Durmaz    |
      | selman@gmail.com |
      | Nederlands       |
      | Dutch            |