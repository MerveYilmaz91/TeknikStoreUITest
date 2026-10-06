package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderContent extends ParentPage {

    public HeaderContent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//a[@aria-label='Logo']")
    public WebElement logo;

    @FindBy(css = "input[aria-label='Search']")
    public WebElement searchInput;

    @FindBy(css = "form[data-selector='search-form'] button")
    public WebElement searchButton;

    @FindBy(css = "a[href='/'] span")
    public WebElement homePageLink;

    @FindBy(css = "a[href*='marmaragazetesi'] span")
    public WebElement newsLink;

    @FindBy(css = "a[href='/blog'] span")
    public WebElement blogLink;

    @FindBy(css = "a[href='/sayfa/iletisim'] span")
    public WebElement contactLink;

    @FindBy(css = ".header-whatsapp")
    public WebElement whatsappNumber;

    @FindBy(css = ".header-phone span")
    public WebElement phoneNumber;

    @FindBy(css = "a[href='/kargo-takibi'] span")
    public WebElement orderTrackingLink;

    @FindBy(css = ".user-text a")
    public WebElement myAccountLink;

    @FindBy(id = "user-login-email")
    public WebElement loginEmailInput;

    @FindBy(css = ".cart-menu a")
    public WebElement shoppingCartLink;

    @FindBy(css = ".cart-content-title")
    public WebElement shoppingCartTitle;

    @FindBy(css = ".contentbox-header h4")
    public WebElement pageTitle;

    @FindBy(css = "h1[itemprop='headline']")
    public WebElement newsTitle;

    @FindBy(css = "a[href='/hesabim/favorilerim']")
    public List<WebElement> favoriteProductsLinks;




    }


