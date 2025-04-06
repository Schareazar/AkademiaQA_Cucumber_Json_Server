Feature: Updating employee

  Scenario: User can update existing employee
    Given Employee already exists
    When User changes employees e-mail address
    Then Employee has updated e-mail address