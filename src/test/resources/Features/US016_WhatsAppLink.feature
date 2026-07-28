Feature: WhatsApp button on header

  Background:
    Given User opens the website.

  Scenario: User successfully opens WhatsApp web with header button
    When User clicks WhatsApp button header.
    Then User confirms button directs WhatsApp Web page.
    And User must see the same phone number as on the button.