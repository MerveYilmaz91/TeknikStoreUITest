package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends ParentPage{
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='cart-list-item-title']")
    public WebElement productNameOnCart;

    @FindBy(css = "div.cart-amount")
    public WebElement cartAmount;

    public int getSepetUrunSayisi() {
        try {
            Thread.sleep(1500);
            String countText = cartAmount.getText().trim();
            return Integer.parseInt(countText);
        } catch (Exception e) {
            return 0;
        }
    }
}

