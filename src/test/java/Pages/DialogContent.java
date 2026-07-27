package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends ParentPage{

    public DialogContent(WebDriver driver) {
        PageFactory.initElements(
                driver, this);
    }

    @FindBy(xpath = "//a[span='Hesabım']")
    public WebElement myAccount;

    @FindBy(id = "user-login-email")
    public WebElement email;

    @FindBy(id = "user-login-pass")
    public WebElement password;

    @FindBy(css = "button[data-selector=\"login-panel-button\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//a[span='Çıkış Yap']")
    public WebElement logoutButton;

    @FindBy(xpath = "//div[@class='header-whatsapp']/a")
    public WebElement headerWhatsapp; // header da bulunan WhatsApp butonu

    @FindBy(xpath = "//div[@class = 'cart-menu']/a")
    public WebElement goToCartButton; // sağ üstte bulunan 'sepetim' butonu

    @FindBy(xpath = "//div[@class = 'cart-content-button']/a")
    public WebElement odemeYapButton; // sepetim butonuna bastıktan sonra cıkan 'ödeme yap butonu'

    @FindBy(xpath = "//div[@class = 'cart-panel-buttons form-group']/a")
    public WebElement alisverisiTamamlaButton; // sepetteki 'alısverişi tamamla' butonu

    @FindBy(xpath = "//*[@href= '/order/step2']")
    public WebElement uyeOlmadanDevamEtButton; // 'alısverişi tamamla' dan sonra gelen 'üye olmadan devam et butonu'

    @FindBy(css = "#email")
    public WebElement orderEmail;

    @FindBy(css = "#firstname")
    public WebElement firstName; // order/step2

    @FindBy(css = "#surname")
    public WebElement surname; // order/step2

    @FindBy(css = "#shippingLocation")
    public WebElement selectTown; // order/step2

    @FindBy(css = "#shippingSubLocation")
    public WebElement selectIlce; // order/step2

    @FindBy(css = "#mobilePhoneNumber")
    public WebElement phoneNumber; // order/step2

    @FindBy(css = "#address")
    public WebElement address; // order/step2

    @FindBy(xpath = "//*[@class = 'btn btn-block btn-primary']")
    public WebElement odemeIslemleriButton; // order/step2

    //https://www.teknikstore.com/uye-girisi?membership=1
    @FindBy(css = "#user-login-email")
    public WebElement uyeGirisiEmail; // üye girişi ekranı email

    @FindBy(css = "user-login-pass")
    public WebElement uyeGirisiPass;

    @FindBy(css = ".btn.btn-primary.btn-block")
    public WebElement girisyapButton;

}
