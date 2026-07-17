package StepDefinitions;

import Pages.DialogContent;
import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.List;

public class _05_LogoutSteps {

    DialogContent dc = new DialogContent(GWD.getDriver());

    @Given("Kullanıcı anasayfaya gider")
    public void kullanıcıSitesineGider() {
        GWD.getDriver().get("https://www.teknikstore.com/");
    }

    @Given("Kullanıcı geçerli email ve şifre bilgileriyle giriş yapar")
    public void kullanıcıGecerliEmailVeSifreBilgileriyleGirişYapar() {
        String email = "Test@gmail.com";
        String password = "Tester123";

        ParentPage.myClick(dc.loginButtonOnHeader);
        ParentPage.mySendKeys(dc.loginEmailInput, email);
        ParentPage.mySendKeys(dc.loginPasswordInput, password);
        ParentPage.myClick(dc.loginButton);
    }

    @Then("Kullanıcı başarıyla giriş yapıp hesap alanına erişebilmelidir")
    public void kullanıcıBasarıylaGirişYapıpHesapAlanınaErisebilmelidir() {
        ParentPage.myClick(dc.myAccountMenu);
        String actualText = dc.accountDashboardHeader.getText();
        System.out.println(actualText);
        Assert.assertTrue(actualText.contains("Hoş Geldiniz"),
                "Giriş başarısız! Hesap sayfasında 'Hoş Geldiniz' yazısı bulunamadı.");
    }

    @When("Kullanıcı hesap menüsünden cikis yap seçeneğini görmelidir")
    public void kullanıcıHesapMenüsündenSeçeneğiniGörmelidir() {

        Assert.assertTrue(dc.logoutLink.isDisplayed());
    }

    @When("Kullanıcı cikis yap seçeneğine tıklar")
    public void kullanıcıÇıkışYapSeçeneğineTıklar() {
        ParentPage.myClick(dc.logoutLink);
    }

    @Then("Kullanıcının sistemden güvenli bir şekilde çıktığı doğrulanmalıdır")
    public void kullanıcınınSistemdenGüvenliBirŞekildeÇıktığıDoğrulanmalıdır() {
        String buttonText = dc.loginButtonOnHeader.getText();
        Assert.assertTrue(buttonText.contains("Giriş Yap"),"Kullanıcı güvenli çıkış yapamadı! Giriş Yap butonu görünmüyor.");
    }

    @And("Kullanıcı tekrar login sayfasına veya ana sayfaya yönlendirilmelidir")
    public void kullanıcıTekrarLoginSayfasınaVeyaAnaSayfayaYönlendirilmelidir() {
        String currentUrl = GWD.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.teknikstore.com/");
    }

    @Then("Kullanıcının aşağıdaki sayfalara erişemediği ve tekrar login istendiği doğrulanır:")
    public void kullanıcınınAsagıdakiSayfalaraErisemedigiDogrulanır(List<String> urller) {

        for (String url : urller) {
            GWD.getDriver().get(url);

            Assert.assertTrue(dc.buttonAfterLogout.isDisplayed(),
                    "HATA: " + url + " sayfasına yetkisiz erişim engellenemedi!");

            System.out.println("BAŞARILI: " + url + " sayfasına erişim engellendi ve Login butonunun göründüğü doğrulandı.");
        }
    }
}
