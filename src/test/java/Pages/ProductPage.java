package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends ParentPage{

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "span[title='42']")
    public WebElement selectProductSize;

    @FindBy(xpath = "a[data-product-id='18107']")
    public WebElement addToCartButton;

    @FindBy(css = "div[class='cart-amount']")
    public WebElement cartAmount;

    @FindBy(css = "div[class='product-title']")
    public WebElement productNameOnPP;

    @FindBy(css = "div[class='product-price-old']")
    public WebElement productPrizeOnPP;

    @FindBy(css = "a[class='cart-list-item-title']")
    public WebElement productNameOnCart;

    @FindBy(css = "div[class='cart-content-total-price']")
    public WebElement productPrizeOnCart;

}
