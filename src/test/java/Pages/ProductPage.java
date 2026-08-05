package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends ParentPage {

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[title='43']")
    public WebElement selectProductSize;

    @FindBy(css = "a[class='add-to-cart-button']:first-of-type")
    public WebElement addToCartButton;

    @FindBy(css = "div[class='product-title']")
    public WebElement productNameOnPP;

    @FindBy(xpath = "//span[contains(text(),'ALIŞVERİŞE DEVAM ET')]")
    public WebElement alisveriseDevamEt;

}
