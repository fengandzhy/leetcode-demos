Feature: Calculator

  Scenario: Add two numbers
    Given the calculator is run
    When I add 2 and 3
    Then the result should be 5