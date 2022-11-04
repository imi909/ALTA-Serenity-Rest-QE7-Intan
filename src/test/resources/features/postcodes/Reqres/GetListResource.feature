Feature: Get List Resource

  @tugas
  Scenario Outline: Get list resource with valid parameter page
    Given Get list resource with parameter page <page>
    When Send get list resource
    Then Status code should be 200 OK
    And Validate list resource json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  @tugas
  Scenario Outline: Get single resource with valid id
    Given Get single resource with parameter id <id>
    When Send get single resource
    Then Status code should be 200 OK
    And Validate single resource json schema
  Examples:
    | id |
    | 2  |
    | 3  |

  @tugas
  Scenario Outline: Get single resource with invalid parameter id
    Given Get single resource with parameter id <id>
    When Send get single user request
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 15 |
      | 23 |
