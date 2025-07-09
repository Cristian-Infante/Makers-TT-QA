@regression
Feature: Authentication on SauceDemo

  Background:
    Given the user opens the application

  Scenario: Successful login
    When the user logs in with valid credentials
    Then the inventory should be visible

  Scenario: Failed login with invalid credentials
    When the user attempts to log in with invalid credentials
    Then the error message "Epic sadface" should be displayed
