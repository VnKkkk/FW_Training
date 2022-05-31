Feature: CRUD operations with REST

  Scenario: GET all users with REST
    When I perform a "GET" request to "/users"
    Then I should receive all users
    And Status code "200" with a message "OK"

  Scenario: GET specific user with REST
    When I perform a "GET" request to "/users/3"
    Then I should receive a user with the specific id
    And Status code "200" with a message "OK"

  Scenario: Login admin with REST
    When I perform a "POST" request to "/login"
#    And I filled in the following username and password:"admin@automation.com", "pass123"
#    Then Status code "200" with a message "OK"

  Scenario: POST new user with REST
    When I perform a "POST" request to "/users"