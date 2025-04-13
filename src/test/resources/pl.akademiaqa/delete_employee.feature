Feature: Deleting employee

  Scenario: User can delete existing employee
    Given Employee already exists
    When User deletes existing employee
    Then Deleted employee is not visible on employees list