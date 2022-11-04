Feature: Delayed Response

  @tugas
  Scenario Outline: Get delayed response
    Given Get delayed response with page <delay>
    When Send delayed response
    Then Status code should be 200 OK
#    And Response body should be <delay>
#    And Validate create user json schema
  Examples:
    | delay |
    | 3     |