Feature: CRUD operations with REST

  Scenario: GET all users with REST
    When I perform a "GET" request to "/users"
    Then I should receive all users
    And Status code "200" with a message "OK"

  Scenario: GET specific user with REST
    When I perform a "GET" request to "/users/3"
    Then I should receive a user with the specific id
    And Status code "200" with a message "OK"


  Scenario: POST new user with REST

    When I use the following details:
      | title | first_name | sir_name | email  | password | country  | city    | is_admin |
      | Mr.   | Ivan       | Ivanov   | random | pass123  | Bulgaria | Plovdiv | 0        |
    And I perform a "POST" request to "/users"
    Then Status code "200" with a message "OK"

    Scenario: POST new user with REST and lombok
      When I use the following details with lombok
        | title | first_name | sir_name | email  | password | country  | city    | is_admin |
        | Mr.   | Ivan       | Ivanov   | random | pass123  | Bulgaria | Plovdiv | 0        |
      And I perform a "POST" request to "/users" with lombok
      Then Status code "200" with a message "OK"