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



}
