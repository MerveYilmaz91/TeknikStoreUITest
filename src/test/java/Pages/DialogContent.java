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

    @FindBy(id = "user-login-email")
    public WebElement loginEmailInput;

    @FindBy(id = "user-login-pass")
    public WebElement loginPasswordInput;

    @FindBy(xpath = "//button[contains(text(),'Giriş Yap')]")
    public WebElement loginButton;

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
