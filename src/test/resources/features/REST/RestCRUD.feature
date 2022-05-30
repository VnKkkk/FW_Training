Feature: CRUD operations with REST

  Scenario: GET all users with REST
    When I perform a "GET" request to "/users"
    Then I should receive all users
    And Status code "200" with a message "OK"