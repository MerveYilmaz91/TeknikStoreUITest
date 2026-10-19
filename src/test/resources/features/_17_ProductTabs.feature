Feature:Ana Sayfa Ürün Sekmeleri
  Background:
Given Kullanıcı anasayfaya gider
And Ana sayfada ürün sekmelerinin bulunduğu alanı görüntüler

@AnaSayfaSekmeler
Scenario Template: <sekme_adi> sekmesine tıklanması ve ürün kartlarının doğrulanması
When Kullanıcı "<sekme_adi>" butonuna tıklar
Then Seçilen "<sekme_adi>" sekmesinin aktif göründüğü doğrulanmalıdır
And Sekme altında en az bir adet ürün kartının listelendiği doğrulanmalıdır
And Ürün kartlarında ürün görseli, marka, ürün adı, fiyat ve "Sepete Ekle" (veya "Teklif Al") butonunun görünür olduğu doğrulanmalıdır
And Listelenen ürünlerin "<ozel_kontrol>" kriterine uygun şekilde listelendiği doğrulanmalıdır

  Examples:
| sekme_adi              | ozel_kontrol                                                                                     |
| İndirimdeki Ürünler    | ürün kartında eski fiyat, indirimli fiyat veya indirim oranından en az birinin bulunması         |
| En Çok Satanlar        | ürünlerin dinamik olarak en çok satanlar listesi/alanı yapısında gelmesi                         |
| Yeni Gelen Ürünler     | ürünlerin dinamik olarak yeni ürünler listesi/alanı yapısında gelmesi                            |