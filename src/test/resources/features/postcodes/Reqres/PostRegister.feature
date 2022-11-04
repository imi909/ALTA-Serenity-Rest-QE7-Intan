Feature: Post Register User

  @tugas
  Scenario: Post register user with valid json
    Given Post register user with valid json
    When Send post register user
    Then Status code should be 200 OK
    And Response body should contain id 4 and token "QpwL5tke4Pnpja7X4"
#    And Validate post register json schema

  @tugas
  Scenario: Post register user with invalid json
    Given Post register user with invalid json
    When Send post register user
    Then Status code should be 400 Bad Request
    And Response body should contain error "Missing password"