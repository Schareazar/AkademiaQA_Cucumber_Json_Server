Feature: Creating new employee

  Scenario: User can create new employee
    Given User reads employee list
    When User creates new employee
    Then User can see created employee on employee list