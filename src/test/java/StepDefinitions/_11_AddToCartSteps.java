package StepDefinitions;

import Pages.CartPage;
import Pages.CategoryMenu;
import Pages.ParentPage;
import Pages.ProductPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class _11_AddToCartSteps {

    CategoryMenu cm = new CategoryMenu(GWD.getDriver());
    ProductPage pp = new ProductPage(GWD.getDriver());
    CartPage cp = new CartPage(GWD.getDriver());
    Actions actions = new Actions(GWD.getDriver());
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));

    static String eklenenUrunIsmi = "";
    static String secilenOzellik = "";
    static int sepettekiIlkAdet = 0;

    @Given("Kullanıcı sepete eklenebilir seçenekli bir ürün detay sayfasını görüntüler")
    public void kullaniciUrunAciklamasinaTiklar() throws InterruptedException {
        System.out.println("==== Kategoriye Tıklanıyor ====");
        wait.until(ExpectedConditions.elementToBeClickable(cm.kategori));
        actions.moveToElement(cm.kategori).click().perform();

        System.out.println("==== Sayfa Yüklenmesi Bekleniyor ====");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.xpath("(//div[@class='showcase-title'])[1]")));

        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) Utilities.GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", cm.selectFirstItem);

        Thread.sleep(1500);

        wait.until(ExpectedConditions.elementToBeClickable(cm.selectFirstItem));
        cm.selectFirstItem.click();

        Thread.sleep(2000);
        eklenenUrunIsmi = pp.productNameOnPP.getText().trim();
    }

    @When("Kullanıcı gerekli ürün seçeneklerini \\(beden, renk vb.) seçer")
    public void kullaniciUrunSeceneklerineTiklar(){
        try {
            wait.until(ExpectedConditions.visibilityOf(pp.selectProductSize));

            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) Utilities.GWD.getDriver();
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", pp.selectProductSize);

            Thread.sleep(1000);
            pp.selectProductSize.click();
            System.out.println("Ürün seçeneği (beden/renk) başarıyla seçildi.");

        } catch (Exception e) {
            System.out.println("BİLGİ: Bu üründe seçilecek bir beden/renk varyantı bulunamadı veya locator yüklenmedi.");
        }
    }

    @And("Kullanıcı Sepete Ekle butonuna tıklar ve başarılı ekleme mesajı görmelidir")
    public void kullanıcıButonunaTıklar() throws InterruptedException {

        Thread.sleep(1000);
        pp.addToCartButton.click();
        System.out.println("Urun sepete eklendi");

        pp.alisveriseDevamEt.click();
        System.out.println("Bildirim kapatildi");
    }

    @Then("Sepetim alanındaki ürün adedi güncellenmelidir")
    public void sepetimAlanindaUrunAdediGuncellenmelidir(){

        System.out.println( cp.getSepetUrunSayisi());
        String sepetUrunSayisiMetin = cp.cartAmount.getText().trim();

        int sepetUrunSayisi = Integer.parseInt(sepetUrunSayisiMetin);

        Assert.assertTrue(sepetUrunSayisi > sepettekiIlkAdet,
                "Sepetteki ürün adedi artmadı! Eski: " + sepettekiIlkAdet + ", Yeni: " + sepetUrunSayisi);
    }

    @And("Kullanıcı sepetim alanına tıklar ve ürün özelliklerini seçilen ile uyumlu görmelidir")
    public void kullanıcıSepetimAlanınaTıklarVeÜrünÖzellikleriniSeçilenIleUyumluGörmelidir() {
        ParentPage.myClick(cm.myCartButton);
        String nameCart =cp.productNameOnCart.getText();
        boolean urunBulundu = false;
        if (eklenenUrunIsmi.contains(nameCart.toLowerCase())){
            urunBulundu=true;
        }

        Assert.assertTrue(urunBulundu, "Eklenen ürün veya seçilen özellik sepette bulunamadı!");
    }

    @Given("Kullanıcı sepette zaten var olan bir ürünü tekrar sepete ekler")
    public void kullanıcıSepetteZatenVarOlanBirÜrünüTekrarSepeteEkler() throws InterruptedException {
        ParentPage.myClick(cm.myCartButton);
        ParentPage.myClick(cm.tumKategoriler);
        ParentPage.myClick(cm.kategori);

        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) Utilities.GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", cm.selectFirstItem);

        Thread.sleep(1500);

        wait.until(ExpectedConditions.elementToBeClickable(cm.selectFirstItem));
        cm.selectFirstItem.click();
        pp.addToCartButton.click();
        System.out.println("Urun sepete eklendi");

    }

    @When("Kullanıcı sepet sayfasına gider ve urun bilgilerinin guncellendigini gorur")
    public void kullanıcıSepetSayfasınaGiderVeUrunBilgilerininGuncellendiginiGorur() {
        ParentPage.myClick(cm.myCartButton);
        String amountAfterSecondPurchese = cm.productAmount.getText();

        Assert.assertEquals(amountAfterSecondPurchese, 2, "Urun adeti 2'ye yukselmedi");

    }
}
