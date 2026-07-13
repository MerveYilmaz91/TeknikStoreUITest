Feature: Login

  Scenario: Successful Login

    Given User opens TeknikStore homepage
    When User logs in with valid credentials
    Then User should login successfully