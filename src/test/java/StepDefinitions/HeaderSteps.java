package StepDefinitions;

import Pages.HeaderContent;
import Utilities.GWD;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.Dimension;


public class HeaderSteps {
    HeaderContent hc = new HeaderContent(GWD.getDriver());

    @Then("User should see the TeknikStore logo")
    public void userShouldSeeTheTeknikStoreLogo() {
        Assert.assertTrue(hc.logo.isDisplayed());
    }

    @When("User clicks the TeknikStore logo")
    public void userClicksTheTeknikStoreLogo() {
        hc.logo.click();
    }

    @Then("User should be redirected to the homepage")
    public void userShouldBeRedirectedToTheHomepage() {
        Assert.assertEquals(
                GWD.getDriver().getCurrentUrl(),"https://www.teknikstore.com/");

    }

    @Then("User should see the search input")
    public void userShouldSeeTheSearchInput() {
        Assert.assertTrue(hc.searchInput.isDisplayed());

    }

    @When("User enters {string} into the search input")
    public void userEntersIntoTheSearchInput(String productName) {
        hc.searchInput.sendKeys(productName);
    }

    @And("User clicks the search button")
    public void userClicksTheSearchButton() {
        hc.searchButton.click();

    }

    @Then("User should be redirected to the search results page")
    public void userShouldBeRedirectedToTheSearchResultsPage() {
        Assert.assertTrue(
                GWD.getDriver().getCurrentUrl().contains("eldiven"));
    }

    @Then("User should see the homepage link")
    public void userShouldSeeTheHomepageLink() {
        Assert.assertTrue(hc.homePageLink.isDisplayed());
        Assert.assertEquals(hc.homePageLink.getText(), "Anasayfa");
    }

    @And("User should see the news link")
    public void userShouldSeeTheNewsLink() {
        Assert.assertTrue(hc.newsLink.isDisplayed());
        Assert.assertEquals(hc.newsLink.getText(), "Bizden Haberler");
    }

    @And("User should see the blog link")
    public void userShouldSeeTheBlogLink() {
        Assert.assertTrue(hc.blogLink.isDisplayed());
        Assert.assertEquals(hc.blogLink.getText(), "Blog");
    }

    @And("User should see the contact link")
    public void userShouldSeeTheContactLink() {
        Assert.assertTrue(hc.contactLink.isDisplayed());
        Assert.assertEquals(hc.contactLink.getText(), "İletişim");
    }

    @Then("User should see the WhatsApp number")
    public void userShouldSeeTheWhatsAppNumber() {
        Assert.assertTrue(hc.whatsappNumber.isDisplayed());
    }

    @And("User should see the phone number")
    public void userShouldSeeThePhoneNumber() {
        Assert.assertTrue(hc.phoneNumber.isDisplayed());
    }

    @Then("User should see the order tracking link")
    public void userShouldSeeTheOrderTrackingLink() {
        Assert.assertTrue(hc.orderTrackingLink.isDisplayed());
    }

    @When("User clicks the order tracking link")
    public void userClicksTheOrderTrackingLink() {
        hc.orderTrackingLink.click();
    }

    @Then("User should be redirected to the order tracking page")
    public void userShouldBeRedirectedToTheOrderTrackingPage() {
        Assert.assertTrue(
                GWD.getDriver().getCurrentUrl().contains("kargo-takibi"));

    }

    @Then("User should see the my account link")
    public void userShouldSeeTheMyAccountLink() {
        Assert.assertTrue(hc.myAccountLink.isDisplayed());
    }

    @When("User clicks the my account link")
    public void userClicksTheMyAccountLink() {
        hc.myAccountLink.click();
    }

    @Then("User should see the login area")
    public void userShouldSeeTheLoginArea() {
        Assert.assertTrue(hc.loginEmailInput.isDisplayed());
    }

    @Then("User should see the shopping cart link")
    public void userShouldSeeTheShoppingCartLink() {
        Assert.assertTrue(hc.shoppingCartLink.isDisplayed());
    }

    @When("User clicks the shopping cart link")
    public void userClicksTheShoppingCartLink() {
        hc.shoppingCartLink.click();
    }

    @Then("User should see the shopping cart area")
    public void userShouldSeeTheShoppingCartArea() {
        Assert.assertTrue(hc.shoppingCartTitle.isDisplayed());
    }

    @When("User clicks the homepage link")
    public void userClicksTheHomepageLink() {
        hc.homePageLink.click();
    }

    @When("User clicks the news link")
    public void userClicksTheNewsLink() {
        hc.newsLink.click();

        for (String window : GWD.getDriver().getWindowHandles()) {
            GWD.getDriver().switchTo().window(window);
        }
    }

    @Then("User should be redirected to the news page")
    public void userShouldBeRedirectedToTheNewsPage() {
        Assert.assertTrue(
                GWD.getDriver().getCurrentUrl().contains("marmaragazetesi.com"));
        Assert.assertEquals(
                hc.newsTitle.getText(),
                "Teknik Store online satış");
    }

    @When("User clicks the blog link")
    public void userClicksTheBlogLink() {
        hc.blogLink.click();
    }

    @Then("User should be redirected to the blog page")
    public void userShouldBeRedirectedToTheBlogPage() {
        Assert.assertTrue(
                GWD.getDriver().getCurrentUrl().contains("/blog"));
        Assert.assertEquals(
                hc.pageTitle.getText(),
                "Tüm Bloglar");
    }

    @When("User clicks the contact link")
    public void userClicksTheContactLink() {
        hc.contactLink.click();
    }

    @Then("User should be redirected to the contact page")
    public void userShouldBeRedirectedToTheContactPage() {
        Assert.assertTrue(
                GWD.getDriver().getCurrentUrl().contains("/sayfa/iletisim"));
        Assert.assertEquals(
                hc.pageTitle.getText(),
                "İletişim");
    }

    @And("User should see the favorite products link")
    public void userShouldSeeTheFavoriteProductsLink() {

        GWD.getDriver().manage().window().setSize(new Dimension(1920, 1080));

        WebElement visibleFavoriteLink = hc.favoriteProductsLinks.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() ->
                        new AssertionError("Görünür Favori Ürünlerim linki bulunamadı"));

        Assert.assertTrue(
                visibleFavoriteLink.getText().contains("Favori"));
    }

    @When("User clicks the favorite products link")
    public void userClicksTheFavoriteProductsLink() {

        WebElement visibleFavoriteLink = hc.favoriteProductsLinks.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() ->
                        new AssertionError("Tıklanabilir Favori Ürünlerim linki bulunamadı"));

        visibleFavoriteLink.click();
    }

    @Then("User should see the favorite products page")
    public void userShouldSeeTheFavoriteProductsPage() {
        Assert.assertTrue(
                GWD.getDriver().getCurrentUrl().contains("/hesabim/favorilerim"));

        Assert.assertEquals(
                hc.pageTitle.getText(),
                "Favori Ürünlerim");
    }
}
