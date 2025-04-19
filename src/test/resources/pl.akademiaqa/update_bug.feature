Feature: Updating bug

  Scenario: User can close bug
    Given Bug already exists
    When User closes existing bug
    Then Bug status is closed