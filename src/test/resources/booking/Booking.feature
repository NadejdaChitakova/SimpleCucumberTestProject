Feature: Make an appointment with a dentist

  Background:
    Given I want to see available periods
    When I select available period
    And Enter my data

  Scenario: I want to make an appointment with a dentist like unregistred user
    Then I receive a confirmation email

  Scenario: I want to make an appointment with a dentist like registred user
    Then I receive a confirmation email

  Scenario: I want to make an appointment with a dentist like dentist
    Then I dont receive a confirmation email
