Feature: Patch Update User

  @tugas
  Scenario Outline: Patch update user with valid json test
    Given Patch update user with valid json with id <id>
    When Send patch update user request
    Then Status code should be 200 OK
    And Response body should contain name "IMI Patch Update" and job "QA Patch Update"
    And Validate patch update user json schema
    Examples:
      | id |
      | 1  |
      | 2  |