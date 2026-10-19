
Feature:Kullanıcı Çıkış Yapma (Logout) Fonksiyonu

Scenario: Kullanıcı Arayüz Üzerinden Güvenli Çıkış Yapabilmeli
Given Kullanıcı anasayfaya gider
And Kullanıcı geçerli email ve şifre bilgileriyle giriş yapar
And Kullanıcı başarıyla giriş yapıp hesap alanına erişebilmelidir
When Kullanıcı hesap menüsünden cikis yap seçeneğini görmelidir
And Kullanıcı cikis yap seçeneğine tıklar
Then Kullanıcının sistemden güvenli bir şekilde çıktığı doğrulanmalıdır
And Kullanıcı tekrar login sayfasına veya ana sayfaya yönlendirilmelidir
Then Kullanıcının aşağıdaki sayfalara erişemediği ve tekrar login istendiği doğrulanır:
    | https://www.teknikstore.com/hesabim             |
    | https://www.teknikstore.com/hesabim/favorilerim |
    | https://www.teknikstore.com/hesabim/siparisler  |