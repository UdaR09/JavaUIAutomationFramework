Feature: The register Flow test suite

  Scenario:  The system redirects the user to Account page after successfull registration
    Given The home page is displayed
    And Register Page is accessed from Home Page buttons
    And The register form is populated with data
    And The privacy policy is enabled
    When Continue button is clicked
    Then the URL contains the following keyword "account/success"

    @run
    Scenario: The system keeps the user on Register page when registering without accepting privacy rules
      Given The home page is displayed
      And Register Page is accessed from Home Page buttons
      And The register form is populated with data
      When Continue button is clicked
      Then the URL contains the following keyword "register"