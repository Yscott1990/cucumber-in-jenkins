
Feature: test calculator service

  Scenario: test calculator with integer
    Given I have MainApp running
    When I set value to 2
    And I wait for 1 seconds
    Then I should have 4

    Given I have MainApp running
    When I set value to 5
    And I wait for 1 seconds
    Then I should have 7

    Given I have MainApp running
    When I set value to 1000
    And I wait for 1 seconds
    Then I should have 1002

    Given I have MainApp running
    When I set value to 10000
    And I wait for 1 seconds
    Then I should have 10002





