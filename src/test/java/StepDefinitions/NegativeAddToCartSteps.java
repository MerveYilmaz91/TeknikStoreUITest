package StepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import Pages.HeaderContent;
import Pages.NegativeAddToCartPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NegativeAddToCartSteps {

    HeaderContent hc = new HeaderContent(GWD.getDriver());
    NegativeAddToCartPage np = new NegativeAddToCartPage(GWD.getDriver());


    @When("User searches for {string}")
    public void userSearchesFor(String productName) {
        hc.searchInput.sendKeys(productName);
        hc.searchButton.click();

    }

    @And("User opens the required size product")
    public void userOpensTheRequiredSizeProduct() {

        JavascriptExecutor js =
                (JavascriptExecutor) GWD.getDriver();

        js.executeScript(
                "arguments[0].click();",
                np.workPantsProduct
        );

        try {
            np.cookieAcceptButton.click();
        } catch (Exception e) {
            // Cookie görünmüyorsa devam et
        }
    }

    @And("User clicks the add to cart button without selecting size")
    public void userClicksTheAddToCartButtonWithoutSelectingSize() {
        JavascriptExecutor js =
                (JavascriptExecutor) GWD.getDriver();

        js.executeScript(
                "arguments[0].click();",
                np.addToCartButton);
    }

    @Then("User should see the required option warning")
    public void userShouldSeeTheRequiredOptionWarning() {
        Assert.assertTrue(np.warningMessage.isDisplayed());

        Assert.assertTrue(
                np.warningMessage.getText().contains("lütfen bir seçenek seçiniz"));
    }


    @And("Product should not be added to the cart")
    public void productShouldNotBeAddedToTheCart() {
        Assert.assertEquals(np.cartItemCount.getText(), "0");
    }

    @And("User selects size {string}")
    public void userSelectsSize(String arg0) {
        JavascriptExecutor js =
                (JavascriptExecutor) GWD.getDriver();

        js.executeScript(
                "arguments[0].click();",
                np.size46Button);
    }

    @And("User enters quantity {string}")
    public void userEntersQuantity(String quantity) {
        JavascriptExecutor js =
                (JavascriptExecutor) GWD.getDriver();

        js.executeScript(
                "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', {bubbles:true}));",
                np.quantityInput,
                quantity);
    }

    @And("User clicks the add to cart button")
    public void userClicksTheAddToCartButton() {
        JavascriptExecutor js =
                (JavascriptExecutor) GWD.getDriver();

        js.executeScript(
                "arguments[0].click();",
                np.addToCartButton
        );
    }

    @Then("User should see the invalid quantity warning")
    public void userShouldSeeTheInvalidQuantityWarning() {
        WebDriverWait wait =
                new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions.visibilityOf(np.warningMessage));
    }


    @And("User tries to enter negative quantity")
    public void userTriesToEnterNegativeQuantity() {
        np.quantityInput.click();

        np.quantityInput.sendKeys("-1");
    }

    @Then("Quantity field should not accept negative value")
    public void quantityFieldShouldNotAcceptNegativeValue() {
        Assert.assertFalse(
                np.quantityInput.getAttribute("value").contains("-"));
    }

    @And("User tries to enter letters in quantity field")
    public void userTriesToEnterLettersInQuantityField() {
        np.quantityInput.click();

        np.quantityInput.sendKeys(
                Keys.chord(Keys.CONTROL, "a"));

        np.quantityInput.sendKeys("abc");
    }

    @Then("Quantity field should not accept letters")
    public void quantityFieldShouldNotAcceptLetters() {
        Assert.assertFalse(
                np.quantityInput.getAttribute("value").contains("abc"));
    }

    @And("User should remain on the product detail page")
    public void userShouldRemainOnTheProductDetailPage() {
        Assert.assertTrue(
                GWD.getDriver().getCurrentUrl().contains("safety-jogger-elm-siyah-cok-cepli-taktik-is-pantolonu"));
    }

    @And("User should not be redirected to checkout page")
    public void userShouldNotBeRedirectedToCheckoutPage() {
        Assert.assertFalse(
                GWD.getDriver().getCurrentUrl().contains("checkout"));

    }

    @And("User opens quote only product")
    public void userOpensQuoteOnlyProduct() {
        np.quoteOnlyProduct.click();

    }

    @Then("User should see only quote button")
    public void userShouldSeeOnlyQuoteButton() {
        Assert.assertTrue(np.quoteButton.isDisplayed());
    }

    @And("User should not see add to cart button")
    public void userShouldNotSeeAddToCartButton() {
        Assert.assertFalse(
                np.quoteButton.getText().contains("Sepete Ekle"));
    }
}
