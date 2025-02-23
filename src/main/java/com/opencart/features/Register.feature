Feature: The register Flow test suite

  Scenario:  The system redirects the user to Account page after successful registration
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And Register Page is accessed from Home Page buttons
    And The register form is populated with data
    And The privacy policy is enabled
    When Continue button is clicked
    Then the URL contains the following keyword "account/success"


  Scenario: The system keeps the user on Register page when registering without accepting privacy rules
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And Register Page is accessed from Home Page buttons
    And The register form is populated with data
    When Continue button is clicked
    Then the URL contains the following keyword "register"

  @run
  Scenario Outline: Error message is displayed when registering with invalid password length
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And Register Page is accessed from Home Page buttons
    When  The register form is populated as following:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | Random      |
      | password  | <password>  |
    When  Continue button is clicked
    And a thread sleep of 5000 miliseconds is executed
    Then  the following list of error messages is displayed:
      | <errorMessage> must be between <min> and <max> characters! |
      | Warning: You must agree to the Privacy Policy!             |
    Examples:
      | firstName |  | lastName                          | password                | errorMessage | min | max |
      | Random    |  | Random                            | 312                     | Password     | 4   | 20  |
      | Random    |  | Stejar                            | 12345678901234567890123 | Password     | 4   | 20  |
      | Random    |  | 123456789012345678901234567890123 | 12345678901234567890123 | Last Name    | 1   | 32  |
