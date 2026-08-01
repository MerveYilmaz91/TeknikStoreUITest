Feature: Product Filter

Scenario Template: : Ürünlerin <siralama_secenegi> kriterine göre başarıyla sıralanması
Given Kullanıcı anasayfaya gider
When Kullanici herhangi bir kategori sayfasina gider
Then Kullanıcı sıralama menüsünden "<siralama_secenegi>" seçeneğini seçerse
And Ürün listesi "<beklenen_durum>" kuralına göre güncellenmelidir

Examples:
| siralama_secenegi   | beklenen_durum                 |
| Önerilen sıralama   | varsayılan sıralama            |
| En düşük fiyat      | fiyata göre düşükten yükseğe   |
| En yüksek fiyat     | fiyata göre yüksekten düşüğe   |
| İndirim oranı       | indirim oranına göre azalan    |
| Yeni eklenenler     | eklenme tarihine göre yeniden  |
| Çok değerlendirilenler| değerlendirme sayısına göre  |
| Yüksek puanlılar    | ürün puanına göre yüksekten    |