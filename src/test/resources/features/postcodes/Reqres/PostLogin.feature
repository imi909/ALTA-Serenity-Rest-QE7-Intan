Feature: Post Login

  @tugas
  Scenario: Post login user with valid json
    Given Post login user with valid json
    When Send post login user
    Then Status code should be 200 OK
    And Response body should contain token "QpwL5tke4Pnpja7X4"

  @tugas
  Scenario: Post login user with invalid json
    Given Post login user with invalid json
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body should contain error "Missing password"