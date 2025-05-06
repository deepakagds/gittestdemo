Feature: Error Validation

  Scenario Outline: Get error message
    Given I landead on the Ecommerce Page
    When  I logged in with username <name> and passwqord <password>
    Then "Incorrect email or passwod" message is displayed

    Examples:
      | name | password |
      |deepakag@yopmail.com | Admin@123 |+
