package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NegativeAddToCartPage extends ParentPage{

    public NegativeAddToCartPage(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "div[data-pid='17943'] .showcase-content a[title='Safety Jogger ELM Siyah Çok Cepli Taktik İş Pantolonu']")
    public WebElement workPantsProduct;

    @FindBy(css = "a[data-selector='add-to-cart']")
    public WebElement addToCartButton;

    @FindBy(css = ".notification.warning")
    public WebElement warningMessage;

    @FindBy(css = "div[data-selector='cart-item-count']")
    public WebElement cartItemCount;

    @FindBy(css = "a.cc-btn.cc-dismiss")
    public WebElement cookieAcceptButton;

    @FindBy(id = "qty-input")
    public WebElement quantityInput;

    @FindBy(css = "span[data-option-title='46']")
    public WebElement size46Button;

    @FindBy(css = "a.add-to-cart-button")
    public WebElement quoteButton;

    @FindBy(css = "a[data-selector='add-to-cart']")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = "//a[@title='BGS 45 Parça M6-M24 El Kılavuzu Ve Pafta Takımı']")
    public WebElement quoteOnlyProduct;


}
