Feature: Checkout page

  Background:
    Given User opens the website.

  Scenario: User successfully opens checkout page goes until payment page





    And User clicks on 'Alısverisi tamamla'.
    And User clicks on 'Uye olmadan devam et'.
    And User enters name.
    And User enters surname.
    And User selects city.
    And User selects subcity.
    And User enters mobile phone number.
    And User enters address.
    And User clicks 'Ödeme İşlemleri'.
    Then User directs to payment page.