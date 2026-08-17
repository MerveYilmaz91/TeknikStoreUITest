package StepDefinitions;

import Pages.DialogContent;
import Utilities.ConfigReader;
import Utilities.GWD;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    DialogContent dc = new DialogContent(GWD.getDriver());

    @Given("User opens TeknikStore homepage")
    public void userOpensTeknikStoreHomepage() {
        GWD.getDriver().get(ConfigReader.getProperty("url"));

    }

    @When("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        dc.myClick(dc.myAccount);

        dc.mySendKeys(dc.email,
                ConfigReader.getProperty("validEmail"));

        dc.mySendKeys(dc.password,
                ConfigReader.getProperty("validPassword"));

        dc.myClick(dc.loginButton);

    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {

        System.out.println(
                "Login sonrası URL: " + GWD.getDriver().getCurrentUrl());

        System.out.println(
                "Logout görünüyor mu: " + dc.logoutButton.isDisplayed());

        Assert.assertTrue(dc.logoutButton.isDisplayed());
    }
}
