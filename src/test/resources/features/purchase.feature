Feature: Purchase
  As a registered user
  I want to add products
  To make a purchase

  Scenario: Purchase products from the shopping car sucessfully
    Given Juan is authenticated
    And add from laptops a Macbook air
    And add from monitor an Apple monitor 24
    When Juan makes the purchase
    Then should see the message Thank you for your purchase
