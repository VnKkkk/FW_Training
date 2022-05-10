Feature: Log in with admin

  Scenario: Log in with admin account
    Given  The LogInPage is opened
    When  The username "admin@automation.com" is filled in
    And the password "pass123" is filled in
    Then User is logged successfully