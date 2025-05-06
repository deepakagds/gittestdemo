Feature: Purchase the order from Ecommarece site

  Background:
  Given I landead on the Ecommerce Page

    @regression
  Scenario Outline: Submit the purchase order.
    Given I logged in with username <name> and passwqord <password>
    When I added product <productName> to the cart
    And  Checkout <productName> and submit the order
    Then "Thankyou for the order." order message is displaying



    Examples:
      | name | password | productName |
      |deepakag@yopmail.com | Admin@123 | ZARA COAT 3 |

