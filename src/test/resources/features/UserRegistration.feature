Feature: User registration

  Scenario: User registration
    Given  The LogInPage is opened
    And The register button is clicked
    When The following details are filled in with
      | title | firstName | sirName | email                | password | country  | city    |
      | Mrs.  | Testi     | Testev  | testi.test@email.com | pass123  | Bulgaria | Plovdiv |
    And I agree with the terms of service is clicked
    And The register button is clicked again
    Then The user is registered successfully

  Scenario Outline: Multiple user registrations
    Given  The LogInPage is opened
    And The register button is clicked
    When The following details are filled in with: '<title>', '<firstName>', '<sirName>', '<email>', '<password>', '<country>', '<city>'
    And I agree with the terms of service is clicked
    And The register button is clicked again
    Then The user is registered successfully.
    Examples:
      | title | firstName | sirName | email           | password | country  | city    |
      | Mrs.  | Tesy      | Testev  | te.t2@email.com | pass123  | Bulgaria | Plovdiv |
      | Mrs.  | Tes       | Testev  | t.2@email.com   | pass123  | Bulgaria | Plovdiv |
