Feature: Footer menu objects

  Background:
    Given User opens the website.

  Scenario: User can see the contact buttons
    When User scrolls down
    Then User can see 'phone' button.
    And User can see 'WhatsApp' button.
    And User can see 'e-mail' button.
    And User can see 'address' button.

  Scenario: User successfully opens "Yeni Üyelik" url.
    When User clicks 'Yeni üyelik' on footer menu.
    Then User directs to 'Yeni Üyelik' page.

  Scenario: User successfully opens "Uye Girişi" url.
    When User clicks 'Üye Girişi' on footer menu.
    Then User directs to 'Üye Girişi' page.

  Scenario: User successfully opens "Şifremi Unuttum" url.
    When User clicks 'Şifremi Unuttum' on footer menu.
    Then User directs to 'Şifremi Unuttum' page.

  Scenario: User successfully opens "İletişim" url.
    When User clicks 'İletişim' on footer menu.
    Then User directs to 'İletişim' page.

  Scenario: User successfully opens "İletişim formu" url.
    When User clicks 'İletişim formu' on footer menu.
    Then User directs to 'İletişim formu' page.

  Scenario: User successfully opens "Havale Bildirim Formu" url.
    When User clicks 'Havale Bildirim Formu' on footer menu.
    And User logs in to website.
    Then User directs to 'Havale Bildirim Formu' page.

  Scenario: User successfully opens "Kargo Takibi" url.
    When User clicks 'Kargo takibi' on footer menu.
    Then User directs to 'Kargo Takibi' page.

  Scenario: User successfully opens "Mesafeli Satış Sözleşmesi" url.
    When User clicks 'Mesafeli Satış Sözleşmesi' on footer menu.
    Then User directs to 'Mesafeli Satış Sözleşmesi' page.

  Scenario: User successfully opens "Gizlilik ve Güvenlik" url.
    When User clicks 'Gizlilik ve güvenlik' footer menu.
    Then User directs to 'Gizlilik ve güvenlik' page.

  Scenario: User successfully opens "İade ve Değişim Koşulları" url.
    When User clicks 'İade ve Değişim Koşulları' on footer menu.
    Then User directs to 'İade ve Değişim Koşulları' page.

  Scenario: User successfully opens "Kişisel Veriler Politikası" url.
    When User clicks 'Kişisel Veriler Politikası' on footer menu.
    Then User directs to 'Kişisel Veriler Politikası' page.

  Scenario: User successfully opens "Sıkça Sorulan Sorular" url.
    When User clicks 'Sıkça Sorulan Sorular' on footer page.
    Then User directs to 'Sıkça Sorulan Sorular' page.

  Scenario: User successfully opens "Site Haritası" url.
    When User clicks 'Site Haritası' on footer menu.
    Then User directs to 'Site Haritası' page.

  Scenario: User successfully opens "Safety Jogger" search.
    When User clicks 'Safety Jogger' on footer page.
    Then User directs to search page for 'Safety Jogger'.

  Scenario: User successfully opens "Outdoor Ayakkabılar" search.
    When User clicks 'Outdoor Ayakkabılar' on footer page.
    Then User directs to search page for 'Outdoor Ayakkabılar'.

  Scenario: User successfully opens "İş Ayakkabıları" search.
    When User clicks 'İş Ayakkabıları' on footer page.
    Then User directs to search page for 'İş Ayakkabıları'.

  Scenario: User successfully opens "Bosch Profesyonel" search.
    When User clicks 'Bosch Profesyonel' on footer page.
    Then User directs to search page for 'Bosch Profesyonel'.

  Scenario: User successfully opens "Karcher Ürünleri" search.
    When User clicks 'Karcher Ürünleri' on footer page.
    Then User directs to search page for 'Karcher Ürünleri'.

  Scenario: User successfully opens "Alüminyum Ürünler" search.
    When User clicks 'Alüminyum Ürünler' on footer page.
    Then User directs to search page for 'Alüminyum Ürünler'.

  Scenario: User successfully opens "Teknik Spreyler" search.
    When User clicks 'Teknik Spreyler' on footer page.
    Then User directs to search page for 'Teknik Spreyler'.

  Scenario: User successfully opens "Çekic ve Balyozlar" search.
    When User clicks 'Çekic ve Balyozlar' on footer page.
    Then User directs to search page for 'Çekic ve Balyozlar'.

  Scenario: User successfully opens "Matkap Uçları" search.
    When User clicks 'Matkap Uçları' on footer page.
    Then User directs to search page for 'Matkap Uçları'.