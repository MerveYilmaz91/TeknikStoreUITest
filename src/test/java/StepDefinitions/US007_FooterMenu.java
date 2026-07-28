package StepDefinitions;

import Pages.DialogContent;
import Pages.FooterContent;
import Pages.ParentPage;
import Utilities.GWD;
import Utilities.MyFunc;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class US007_FooterMenu extends GWD {

    FooterContent fc = new FooterContent(getDriver());
    DialogContent dc = new DialogContent(getDriver());
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    public static void scrolltoElementFalse(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    @Given("User opens the website.")
    public void openWebsite() {
        GWD.getDriver().get("https://www.teknikstore.com/");
    }

    //İletişim sembolleri görünür mü?
    @Then("User can see 'phone' button.")
    public void userCanSeePhoneButton() {
        Assert.assertTrue(fc.phoneFooter.isDisplayed());

    }

    @And("User can see 'WhatsApp' button.")
    public void userCanSeeWhatsAppButton() {
        Assert.assertTrue(fc.whatsappContactFooter.isDisplayed());

    }

    @And("User can see 'e-mail' button.")
    public void userCanSeeEmailButton() {
        Assert.assertTrue(fc.mailFooter.isDisplayed());

    }

    @And("User can see 'address' button.")
    public void userCanSeeAddressButton() {
        Assert.assertTrue(fc.addressFooter.isDisplayed());

    }

    // Yeni uyelik
    @And("User clicks 'Yeni üyelik' on footer menu.")
    public void clickYeniUyelik() {

        scrolltoElementFalse(fc.yeniUyelikFooter);

        wait.until(ExpectedConditions.visibilityOf(fc.yeniUyelikFooter));
        MyFunc.myClick(fc.yeniUyelikFooter);
    }

    @Then("User directs to 'Yeni Üyelik' page.")
    public void confirmsYeniUyelik() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/uye-ol"));
    }

    // Uye girisi
    @And("User clicks 'Üye Girişi' on footer menu.")
    public void clickUyeGirii() {
        wait.until(ExpectedConditions.visibilityOf(fc.uyeGirisiFooter));
        ParentPage.myClick(fc.uyeGirisiFooter);
    }

    @Then("User directs to 'Üye Girişi' page.")
    public void confirmsUyeGirisi() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/uye-girisi"));
    }

    // Sifremi unuttum
    @And("User clicks 'Şifremi Unuttum' on footer menu.")
    public void clickSifremiUnuttum() {
        wait.until(ExpectedConditions.visibilityOf(fc.sifremiUnuttumFooter));
        ParentPage.myClick(fc.sifremiUnuttumFooter);
    }

    @Then("User directs to 'Şifremi Unuttum' page.")
    public void confirmsSifremiUnuttum() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/sifremi-unuttum"));
    }

    // İletişim
    @When("User clicks 'İletişim' on footer menu.")
    public void clickIletisim() {
        scrolltoElementFalse(fc.iletisimFooter);

        wait.until(ExpectedConditions.visibilityOf(fc.iletisimFooter));
        MyFunc.myClick(fc.iletisimFooter);
    }

    @Then("User directs to 'İletişim' page.")
    public void confirmsIletisim() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/iletisim"));
    }

    // İletişim formu
    @When("User clicks 'İletişim formu' on footer menu.")
    public void clickIletisimFormu() {
        wait.until(ExpectedConditions.visibilityOf(fc.iletisimFormuFooter));
        ParentPage.myClick(fc.iletisimFormuFooter);
    }

    @Then("User directs to 'İletişim formu' page.")
    public void confirmsIletisimFormu() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/iletisim-formu"));
    }

    // Havale bildirim formu
    @When("User clicks 'Havale Bildirim Formu' on footer menu.")
    public void clickHavalebildirimFormu() {
        wait.until(ExpectedConditions.visibilityOf(fc.havaleBildirimFooter));
        ParentPage.myClick(fc.havaleBildirimFooter);

    }

    @And("User logs in to website.")
    public void logsIntoWebsite() {
        dc.uyeGirisiEmail.sendKeys("robiv72898@suahi.com");
        dc.uyeGirisiPass.sendKeys("Gamze123!");
        MyFunc.myClick(dc.girisyapButton);

    }

    @Then("User directs to 'Havale Bildirim Formu' page.")
    public void confirmsHavalebildirimFormu() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/havale-bildirim"));
    } // öncesinde login istiyor login eklenince eklenecek

    // Kargo Takibi
    @When("User clicks 'Kargo takibi' on footer menu.")
    public void clickKargoTakibi() {
        wait.until(ExpectedConditions.visibilityOf(fc.kargoTakibiFooter));
        ParentPage.myClick(fc.kargoTakibiFooter);
    }

    @Then("User directs to 'Kargo Takibi' page.")
    public void confirmsKargoTakibi() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/kargo-takibi"));
    }

    // Mesafeli Satış Sözleşmesi
    @When("User clicks 'Mesafeli Satış Sözleşmesi' on footer menu.")
    public void mesafeliSozlesmeClick() {
        wait.until(ExpectedConditions.visibilityOf(fc.mesafeliSatisFooter));
        ParentPage.myClick(fc.mesafeliSatisFooter);
    }

    @Then("User directs to 'Mesafeli Satış Sözleşmesi' page.")
    public void confirmsMesafeliSatis() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/mesafeli-satis"));
    }

    // Gizlilik ve güvenlik
    @When("User clicks 'Gizlilik ve güvenlik' footer menu.")
    public void clickGizlilikVeGizlilik() {
        wait.until(ExpectedConditions.visibilityOf(fc.gizlilikVeGuvenlikFooter));
        ParentPage.myClick(fc.gizlilikVeGuvenlikFooter);
    }

    @Then("User directs to 'Gizlilik ve güvenlik' page.")
    public void confirmsGizlilikVeGizlilik() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/gizlilik-ve-guvenlik"));
    }

    // İade ve değişim koşulları
    @When("User clicks 'İade ve Değişim Koşulları' on footer menu.")
    public void clickIadeveDegisim() {
        wait.until(ExpectedConditions.visibilityOf(fc.iadeVeDegisimFooter));
        ParentPage.myClick(fc.iadeVeDegisimFooter);
    }

    @Then("User directs to 'İade ve Değişim Koşulları' page.")
    public void confirmIadeveDegisim() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/iptal-ve-iade-sartlari"));
    }

    // Kişisel veriler politikası
    @When("User clicks 'Kişisel Veriler Politikası' on footer menu.")
    public void clickKiiselVerilerPolitikasi() {
        wait.until(ExpectedConditions.visibilityOf(fc.kisiselVerilerFooter));
        ParentPage.myClick(fc.kisiselVerilerFooter);
    }

    @Then("User directs to 'Kişisel Veriler Politikası' page.")
    public void confirmsKiiselVerilerPolitikasi() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/kisisel-veriler-politikasi"));
    }

    // Sıkça sorulan sorular
    @When("User clicks 'Sıkça Sorulan Sorular' on footer page.")
    public void clickSikcaSorulanSorular() {
        wait.until(ExpectedConditions.visibilityOf(fc.sikcaSorulanFooter));
        ParentPage.myClick(fc.sikcaSorulanFooter);
    }

    @Then("User directs to 'Sıkça Sorulan Sorular' page.")
    public void confirmSikcaSorulanSorular() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/sikca-sorulanlar"));
    }

    // Site haritası
    @When("User clicks 'Site Haritası' on footer menu.")
    public void clickSiteHaritasi() {
        wait.until(ExpectedConditions.visibilityOf(fc.siteHaritasiFooter));
        ParentPage.myClick(fc.siteHaritasiFooter);
    }

    @Then("User directs to 'Site Haritası' page.")
    public void confirmSiteHaritasi() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("/site-haritasi"));
    }

    //Safety Jogger
    @And("User clicks 'Safety Jogger' on footer page.")
    public void clickSafetyJogger() {
        scrolltoElementFalse(fc.outdoorAyakkabilarFooter);
        wait.until(ExpectedConditions.visibilityOf(fc.outdoorAyakkabilarFooter));
        MyFunc.myClick(fc.outdoorAyakkabilarFooter);
    }

    @Then("User directs to search page for 'Safety Jogger'.")
    public void confirmsSafetyJoggerPage() {
        String url = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("safety-jogger"));
    }

    //Outdoor Ayakkabılar
    @And("User clicks 'Outdoor Ayakkabılar' on footer page.")
    public void clickOutdoorAyakkabilar() {
        scrolltoElementFalse(fc.outdoorAyakkabilarFooter);
        wait.until(ExpectedConditions.visibilityOf(fc.outdoorAyakkabilarFooter));
        MyFunc.myClick(fc.outdoorAyakkabilarFooter);
    }

    @Then("User directs to search page for 'Outdoor Ayakkabılar'.")
    public void confirmsOutdoorAyakkabilarPage() {
        String url = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("outdoor-ayakkabi"));
    }

    //İş Ayakkabıları
    @And("User clicks 'İş Ayakkabıları' on footer page.")
    public void clickIsAyakkabilari() {
        scrolltoElementFalse(fc.isAyakkabilariFooter);
        wait.until(ExpectedConditions.visibilityOf(fc.isAyakkabilariFooter));
        MyFunc.myClick(fc.isAyakkabilariFooter);
    }

    @Then("User directs to search page for 'İş Ayakkabıları'.")
    public void confirmsIsAyakkabilariPage() {
        String url = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("is-ayakkabilari"));
    }

    //Bosch Profesyonel
    @And("User clicks 'Bosch Profesyonel' on footer page.")
    public void clickBoschProfesyonel() {
        scrolltoElementFalse(fc.boschProfesyonelFooter);
        wait.until(ExpectedConditions.visibilityOf(fc.boschProfesyonelFooter));
        MyFunc.myClick(fc.boschProfesyonelFooter);
    }

    @Then("User directs to search page for 'Bosch Profesyonel'.")
    public void confirmsBoschProfesyonelPage() {
        String url = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("bosch"));
    }

    //Karcher Ürünleri
    @And("User clicks 'Karcher Ürünleri' on footer page.")
    public void clickKarcherUrunleri() {
        scrolltoElementFalse(fc.karcherUrunleriFooter);
        wait.until(ExpectedConditions.visibilityOf(fc.karcherUrunleriFooter));
        MyFunc.myClick(fc.karcherUrunleriFooter);
    }

    @Then("User directs to search page for 'Karcher Ürünleri'.")
    public void confirmsKarcherUrunleriPage() {
        String url = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("karcher"));
    }

    //Alüminyum Ürünler
    @And("User clicks 'Alüminyum Ürünler' on footer page.")
    public void clickAluminyumUrunler() {
        scrolltoElementFalse(fc.aluminyumUrunlerFooter);
        wait.until(ExpectedConditions.visibilityOf(fc.aluminyumUrunlerFooter));
        MyFunc.myClick(fc.aluminyumUrunlerFooter);
    }

    @Then("User directs to search page for 'Alüminyum Ürünler'.")
    public void confirmsAluminyumUrunlerPage() {
        String url = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("aluminyum-urunler"));
    }

    //Teknik Spreyler
    @And("User clicks 'Teknik Spreyler' on footer page.")
    public void clickTeknikSpreyler() {
        scrolltoElementFalse(fc.teknikSpreylerFooter);
        wait.until(ExpectedConditions.visibilityOf(fc.teknikSpreylerFooter));
        MyFunc.myClick(fc.teknikSpreylerFooter);
    }

    @Then("User directs to search page for 'Teknik Spreyler'.")
    public void confirmsTeknikSpreylerPage() {
        String url = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("teknik-spreyler"));
    }

    //Çekic ve Balyozlar
    @And("User clicks 'Çekic ve Balyozlar' on footer page.")
    public void clickCekicVeBalyozlar() {
        scrolltoElementFalse(fc.cekicVeBalyozlarFooter);
        wait.until(ExpectedConditions.visibilityOf(fc.cekicVeBalyozlarFooter));
        MyFunc.myClick(fc.cekicVeBalyozlarFooter);
    }

    @Then("User directs to search page for 'Çekic ve Balyozlar'.")
    public void confirmsCekicVeBalyozlarPage() {
        String url = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("cekic-ve-balyoz"));
    }

    //Matkap Uçları
    @And("User clicks 'Matkap Uçları' on footer page.")
    public void clickMatkapUclari() {
        scrolltoElementFalse(fc.matkapUclariFooter);
        wait.until(ExpectedConditions.visibilityOf(fc.matkapUclariFooter));
        MyFunc.myClick(fc.matkapUclariFooter);
    }

    @Then("User directs to search page for 'Matkap Uçları'.")
    public void confirmsMatkapUclariPage() {
        String url = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("matkap-uclari"));
    }
}