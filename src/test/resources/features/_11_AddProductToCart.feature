Feature: Sepete Ürün Ekleme Fonksiyonu

Background: Kullanıcının Siteye Erişmesi
  Given Kullanıcı anasayfaya gider
  And Kullanıcı geçerli email ve şifre bilgileriyle giriş yapar

Scenario: Ürün Detay Sayfasından Seçenekli Ürünün Sepete Başarıyla Eklenmesi
  Given Kullanıcı sepete eklenebilir seçenekli bir ürün detay sayfasını görüntüler
  When Kullanıcı gerekli ürün seçeneklerini (beden, renk vb.) seçer
  And Kullanıcı Sepete Ekle butonuna tıklar ve başarılı ekleme mesajı görmelidir
  Then Sepetim alanındaki ürün adedi güncellenmelidir
  And Kullanıcı sepetim alanına tıklar ve ürün özelliklerini seçilen ile uyumlu görmelidir

  Given Kullanıcı sepette zaten var olan bir ürünü tekrar sepete ekler
  When Kullanıcı sepet sayfasına gider ve urun bilgilerinin guncellendigini gorur