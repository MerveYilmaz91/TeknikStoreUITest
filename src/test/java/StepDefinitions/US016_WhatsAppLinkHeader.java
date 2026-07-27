package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import Pages.ParentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class US016_WhatsAppLinkHeader extends GWD{

    String phoneNumber;

    DialogContent dc = new DialogContent(getDriver());

    @When("User clicks WhatsApp button header.")
    public void WhatsAppButtonHeader() {
        ParentPage.myClick(dc.headerWhatsapp);
        phoneNumber = dc.headerWhatsapp.getText().replace(" ", "");

        List<String> windows = new ArrayList<>(GWD.getDriver().getWindowHandles());
        GWD.getDriver().switchTo().window(windows.get(1));

    }

    @Then("User confirms button directs WhatsApp Web page.")
    public void headerWhatsAppURL() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("whatsapp.com"));

    }

    @And("User must see the same phone number as on the button.")
    public void phoneNumberURL() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains(phoneNumber));

    }




}
