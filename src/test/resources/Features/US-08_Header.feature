Feature: Header Menu Feature

  Background:
    Given User opens TeknikStore homepage

  Scenario:  TeknikStore logo control
    Then User should see the TeknikStore logo
    When User clicks the TeknikStore logo
    Then User should be redirected to the homepage

    Scenario: User should search a product successfully
      Then User should see the search input
      When User enters "eldiven" into the search input
      And User clicks the search button
      Then User should be redirected to the search results page


  Scenario: User should see header menu links
    Then User should see the homepage link
    And User should see the news link
    And User should see the blog link
    And User should see the contact link

  Scenario: User should access homepage
    When User clicks the homepage link
    Then User should be redirected to the homepage

  Scenario: User should access news page
    When User clicks the news link
    Then User should be redirected to the news page

  Scenario: User should access blog page
    When User clicks the blog link
    Then User should be redirected to the blog page

  Scenario: User should access contact page
    When User clicks the contact link
    Then User should be redirected to the contact page

    Scenario: User should see header contact information
      Then User should see the WhatsApp number
      And User should see the phone number

  Scenario: User should access order tracking
    Then User should see the order tracking link
    When User clicks the order tracking link
    Then User should be redirected to the order tracking page

  Scenario: User should access my account
    Then User should see the my account link
    When User clicks the my account link
    Then User should see the login area

  Scenario: User should access favorite products
    When User logs in with valid credentials
    Then User should login successfully
    And User should see the favorite products link
    When User clicks the favorite products link
    Then User should see the favorite products page

  Scenario: User should access shopping cart
    Then User should see the shopping cart link
    When User clicks the shopping cart link
    Then User should see the shopping cart area



