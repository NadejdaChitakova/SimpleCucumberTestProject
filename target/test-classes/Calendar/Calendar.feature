Feature: Adding available periods in calendar

  Background:
    Given I want to get available periods

  Scenario: I want to add available period like dentist
    When I add new periods
    Then I see successfuly added periods

  Scenario:Negative test: I want to add available period like employes
    When I try to insert new dates
    Then I get exception


