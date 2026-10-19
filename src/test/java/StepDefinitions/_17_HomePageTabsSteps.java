package StepDefinitions;

import Pages.CategoryMenu;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class _17_HomePageTabsSteps {

    CategoryMenu cm = new CategoryMenu(GWD.getDriver());

    @And("Ana sayfada ürün sekmelerinin bulunduğu alanı görüntüler")
    public void anaSayfadaUrunSekmelerininBulunduguAlaniGoruntuler() {
        Assert.assertTrue(cm.isTabContainerVisible(), "Ürün sekmeleri alanı görüntülenemedi!");
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullaniciButonunaTiklar(String sekmeAdi) {
        cm.clickProductTab(sekmeAdi);
    }

    @Then("Seçilen {string} sekmesinin aktif göründüğü doğrulanmalıdır")
    public void secilenSekmeninAktifGorunduguDogrulanmalidir(String sekmeAdi) {
        Assert.assertTrue(cm.isTabActive(sekmeAdi), sekmeAdi + " sekmesi aktif duruma geçmedi!");
    }

    @And("Sekme altında en az bir adet ürün kartının listelendiği doğrulanmalıdır")
    public void sekmeAltindaEnAzBirAdetUrunKartininListelendigiDogrulanmalidir() {
        Assert.assertTrue(cm.getVisibleProductCount() > 0, "Sekme altında hiç ürün listelenmedi!");
    }

    @And("Ürün kartlarında ürün görseli, marka, ürün adı, fiyat ve {string} \\(veya {string}) butonunun görünür olduğu doğrulanmalıdır")
    public void urunKartlarindaGerekliAlanlarinGorunurOlduguDogrulanmalidir(String btn1, String btn2) {
        boolean isAllValid = cm.verifyAllProductCardElements();
        Assert.assertTrue(isAllValid, "Ürün kartlarında eksik alanlar (Görsel, İsim, Fiyat vb.) tespit edildi!");
    }

    @And("Listelenen ürünlerin {string} kriterine uygun şekilde listelendiği doğrulanmalıdır")
    public void listelenenUrunlerinKriterineUygunSekildeListelendigiDogrulanmalidir(String ozelKontrol) {
        if (ozelKontrol.contains("indirim oranından en az birinin bulunması")) {
            Assert.assertTrue(cm.verifyDiscountLabels(), "İndirimli ürünlerde fiyat veya oran etiketi eksik!");
        } else {
            Assert.assertTrue(cm.getVisibleProductCount() > 0);
        }
    }
}

