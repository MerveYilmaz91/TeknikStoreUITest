Feature: Negative Add Product to Cart Feature

  Background:
    Given User opens TeknikStore homepage

  Scenario: User should not add product to cart without selecting size
    When User searches for "iş pantolonu"
    And User opens the required size product
    And User clicks the add to cart button without selecting size
    Then User should see the required option warning
    And Product should not be added to the cart
    And User should remain on the product detail page
    And User should not be redirected to checkout page


  Scenario: User should not add product to cart with quantity zero
    When User searches for "iş pantolonu"
    And User opens the required size product
    And User selects size "46"
    And User enters quantity "0"
    And User clicks the add to cart button
    Then User should see the invalid quantity warning
    And Product should not be added to the cart

  Scenario: User should not add product to cart with empty quantity
    When User searches for "iş pantolonu"
    And User opens the required size product
    And User selects size "46"
    And User enters quantity ""
    And User clicks the add to cart button
    Then User should see the invalid quantity warning
    And Product should not be added to the cart

  Scenario: User should not enter negative quantity
    When User searches for "iş pantolonu"
    And User opens the required size product
    And User selects size "46"
    And User tries to enter negative quantity
    Then Quantity field should not accept negative value

  Scenario: User should not enter letters in quantity field
    When User searches for "iş pantolonu"
    And User opens the required size product
    And User selects size "46"
    And User tries to enter letters in quantity field
    Then Quantity field should not accept letters

  Scenario: User should not add product with quote button to cart
    When User searches for "BGS 45 Parça"
    And User opens quote only product
    Then User should see only quote button
    And User should not see add to cart button
    And Product should not be added to the cart