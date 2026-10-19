package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends ParentPage {

    public DialogContent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Master branch - Existing elements

    @FindBy(xpath = "//a[span='Hesabım']")
    public WebElement myAccount;

    @FindBy(id = "user-login-email")
    public WebElement email;

    @FindBy(id = "user-login-pass")
    public WebElement password;

    @FindBy(css = "button[data-selector='login-panel-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[span='Çıkış Yap']")
    public WebElement logoutButton;

    @FindBy(xpath = "//div[@class='header-whatsapp']/a")
    public WebElement headerWhatsapp;

    @FindBy(xpath = "//div[@class='cart-menu']/a")
    public WebElement goToCartButton;

    @FindBy(xpath = "//div[@class='cart-content-button']/a")
    public WebElement odemeYapButton;

    @FindBy(xpath = "//div[@class='cart-panel-buttons form-group']/a")
    public WebElement alisverisiTamamlaButton;

    @FindBy(xpath = "//*[@href='/order/step2']")
    public WebElement uyeOlmadanDevamEtButton;

    @FindBy(css = "#email")
    public WebElement orderEmail;

    @FindBy(css = "#firstname")
    public WebElement firstName;

    @FindBy(css = "#surname")
    public WebElement surname;

    @FindBy(css = "#shippingLocation")
    public WebElement selectTown;

    @FindBy(css = "#shippingSubLocation")
    public WebElement selectIlce;

    @FindBy(css = "#mobilePhoneNumber")
    public WebElement phoneNumber;

    @FindBy(css = "#address")
    public WebElement address;

    @FindBy(xpath = "//*[@class='btn btn-block btn-primary']")
    public WebElement odemeIslemleriButton;

    @FindBy(css = "#user-login-email")
    public WebElement uyeGirisiEmail;

    @FindBy(css = "user-login-pass")
    public WebElement uyeGirisiPass;

    @FindBy(css = ".btn.btn-primary.btn-block")
    public WebElement girisyapButton;

    // Izzet branch - Additional elements

    @FindBy(id = "user-login-email")
    public WebElement loginEmailInput;

    @FindBy(id = "user-login-pass")
    public WebElement loginPasswordInput;

    @FindBy(xpath = "//button[contains(text(),'Giriş Yap')]")
    public WebElement izzetLoginButton;

    @FindBy(xpath = "//span[contains(text(),'Hesabım')]")
    public WebElement myAccountMenu;

    @FindBy(css = "div[class='user-menu-title']")
    public WebElement accountDashboardHeader;

    @FindBy(xpath = "//a[contains(text(),'Çıkış Yap')]")
    public WebElement logoutLink;

    @FindBy(xpath = "//span[contains(text(),'Giriş Yap')]")
    public WebElement loginButtonOnHeader;

    @FindBy(css = "input[placeholder='Email']")
    public WebElement buttonAfterLogout;
}