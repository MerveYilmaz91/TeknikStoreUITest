package StepDefinitions;

import Pages.DialogContent;
import Pages.ParentPage;
import Utilities.FakerClass;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class US010_CheckoutPaymentPage extends GWD {

    DialogContent dc = new DialogContent(getDriver());


    //sepete ekleme kısmını atladım direkt sepetten

    @And("User clicks on 'Alısverisi tamamla'.")
    public void alisverisiTamamlaButton() {
        //eklenen ürünlerin dogrulugu baska adımda kontrol edilmişti yine de eklemeli miyim?
        ParentPage.myClick(dc.alisverisiTamamlaButton);

    }

    @And("User clicks on 'Uye olmadan devam et'.")
    public void uyeOlmadanDevamEt() {
        ParentPage.myClick(dc.uyeOlmadanDevamEtButton);

    }

    @And("User enters email.")
    public void emailSend() {
        ParentPage.mySendKeys(dc.orderEmail, FakerClass.randomEmail());

    }

    @And("User enters name.")
    public void nameSend() {
        ParentPage.mySendKeys(dc.firstName, FakerClass.firstName());

    }

    @And("User enters surname.")
    public void surnameSend() {
        ParentPage.mySendKeys(dc.surname, FakerClass.lastName());

    }

    @And("User selects city.")
    public void citySelect() {
        Select selectCity = new Select(dc.selectTown);
        selectCity.selectByValue("11");

    }

    @And("User selects subcity.")
    public void subcitySelect() {
        Select selectCity = new Select(dc.selectIlce);
        selectCity.selectByValue("100");

    }

    @And("User enters mobile phone number.")
    public void phoneNumberSend() {
        ParentPage.mySendKeys(dc.phoneNumber, FakerClass.phoneNumber());

    }

    @And("User enters address.")
    public void addressSend() {
        ParentPage.mySendKeys(dc.address, FakerClass.fullAddress());

    }

    @And("User clicks 'Ödeme İşlemleri'.")
    public void odemeIslemleriClick() {
        ParentPage.myClick(dc.odemeIslemleriButton);

    }

    @Then("User directs to payment page.")
    public void directsToPaymentPage() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/order/step3"));

    }
}
