@regression
Feature: Purchase flow on SauceDemo

  Background:
    Given the user opens the application
    And the user logs in with valid credentials

  Scenario: Add two products to the cart
    When the user adds "Sauce Labs Backpack" and "Sauce Labs Bike Light" to the cart
    Then the cart badge should show "2"

  Scenario: Complete checkout successfully
    Given the cart contains "Sauce Labs Backpack"
    When the user checks out providing first name "John", last name "Doe" and zip "12345"
    Then the confirmation page should display "Thank you for your order!"
