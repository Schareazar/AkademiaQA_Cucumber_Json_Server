Feature: Creating bug

  Scenario: User can create multiple bugs
    Given User reads bug list
    When User creates multiple bugs
      | title        | description        | employeeId | status
      | First title  | First description  | 1          | open
      | Second title | Second description | 2          | open
      | Third title  | Third description  | 3          | open
    Then User can see all created bugs on bug list