package StepDefinitions;

import Pages.CategoryMenu;
import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class _15_ProductFilterSteps {

    CategoryMenu cm = new CategoryMenu(GWD.getDriver());
    Actions actions = new Actions(GWD.getDriver());

    @When ("Kullanici herhangi bir kategori sayfasina gider")
    public void kullaniciKategoriSecer(){
        actions.moveToElement(cm.kategori).click().perform();
    }

    @Then("Ürün listeleme sayfasında ürün kartlarının ve sıralama menüsünün görünür olduğunu doğrular")
    public void ürünListelemeSayfasındaÜrünKartlarınınVeSıralamaMenüsününGörünürOlduğunuDoğrular() {

        Assert.assertTrue(cm.selectFirstItem.isDisplayed(),"Element sayfada görünür durumda değil");

        Assert.assertTrue(cm.filterDropdown.isDisplayed(), "Siralama ölçütleri görünür durumda değil");
    }

    @When("Kullanıcı sıralama menüsünden {string} seçeneğini seçerse")
    public void kullaniciSiralamaMenusundenSeceneginiSecerse(String siralamaSecenegi) {
        ParentPage.scrollTopWithActions();
        cm.selectSortOption(siralamaSecenegi);
    }

    @Then("Ürün listesi {string} kuralına göre güncellenmelidir")
    public void urunListesiKuralinaGoreGuncellenmelidir(String beklenenDurum) {

        switch (beklenenDurum) {
            case "fiyata göre düşükten yükseğe":
                List<Double> actualPricesAsc = cm.getProductPrices();
                boolean isAscending = cm.isListSortedAscending(actualPricesAsc);
                Assert.assertTrue(isAscending);
                break;

            case "fiyata göre yüksekten düşüğe":
                List<Double> actualPricesDesc = cm.getProductPrices();
                boolean isDescending = cm.isListSortedDescending(actualPricesDesc);
                Assert.assertTrue(isDescending);
                break;

            case "indirim oranına göre azalan":
                List<Integer> discountRates = cm.getProductDiscountRates();
                boolean isDiscountSorted = cm.isIntegerListSortedDescending(discountRates);
                Assert.assertTrue(isDiscountSorted);
                break;

            case "varsayılan sıralama":
            case "eklenme tarihine göre yeniden":
            case "değerlendirme sayısına göre":
            case "ürün puanına göre yüksekten":
                Assert.assertTrue(cm.isProductListDisplayedAndNotEmpty());
                break;

            default:
                Assert.fail("Tanımsız sıralama kuralı: " + beklenenDurum);
        }
    }
}

