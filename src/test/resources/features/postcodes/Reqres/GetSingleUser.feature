Feature: Get Single User

  @tugas
  Scenario Outline: Get single user with valid parameter id
    Given Get single user with parameter id <id>
    When Send get single user request
    Then Status code should be 200 OK
  Examples:
    | id |
    | 2  |
    | 3  |

  @tugas
  Scenario Outline: Get single user with invalid parameter id
    Given Get single user with parameter id <id>
    When Send get single user request
    Then Status code should be 404 Not Found
  Examples:
    | id |
    | 15 |
    | 23 |