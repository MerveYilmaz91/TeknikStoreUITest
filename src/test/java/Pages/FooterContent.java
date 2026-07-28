package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterContent extends ParentPage {
    public FooterContent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    //Musteri hizmetleri
    @FindBy(css = ".footer-phone")
    public WebElement phoneFooter;

    @FindBy(css = ".footer-whatsapp")
    public WebElement whatsappContactFooter;

    @FindBy(css = ".footer-mail")
    public WebElement mailFooter;

    @FindBy(css = ".footer-address")
    public WebElement addressFooter;

    //Uyelik
    @FindBy(xpath = "//*[@title='Yeni Üyelik']")
    public WebElement yeniUyelikFooter;

    @FindBy(xpath = "//*[@title='Üye Girişi']")
    public WebElement uyeGirisiFooter;

    @FindBy(xpath = "//*[@title='Şifremi Unuttum']")
    public WebElement sifremiUnuttumFooter;


    //Kurumsal
    @FindBy(xpath = "//*[@title='İletişim']")
    public WebElement iletisimFooter;

    @FindBy(xpath = "//*[@title='İletişim Formu']")
    public WebElement iletisimFormuFooter;

    @FindBy(xpath = "//*[@title='Havale Bildirim Formu']")
    public WebElement havaleBildirimFooter;

    @FindBy(xpath = "//*[@title='Kargo Takibi']")
    public WebElement kargoTakibiFooter;

    @FindBy(xpath = "//*[@title='Mesafeli Satış Sözleşmesi']")
    public WebElement mesafeliSatisFooter;

    @FindBy(xpath = "//*[@title='Gizlilik ve Güvenlik']")
    public WebElement gizlilikVeGuvenlikFooter;

    @FindBy(xpath = "//*[@title='İptal ve İade Koşullari']")
    public WebElement iadeVeDegisimFooter;

    @FindBy(xpath = "//*[@title='Kişisel Veriler Politikası']")
    public WebElement kisiselVerilerFooter;

    @FindBy(xpath = "//*[@title='Sıkça Sorulan Sorular']")
    public WebElement sikcaSorulanFooter;

    @FindBy(xpath = "//*[@href='https://www.teknikstore.com/sayfa/site-haritasi']")
    public WebElement siteHaritasiFooter;


    //Alısveris
    @FindBy(xpath = "//*[@title='Safety Jogger']")
    public WebElement safetyJoggerFooter;

    @FindBy(xpath = "//*[@title='Outdoor Ayakkabılar']")
    public WebElement outdoorAyakkabilarFooter;

    @FindBy(xpath = "//*[@title='İş Ayakkabıları']")
    public WebElement isAyakkabilariFooter;

    @FindBy(xpath = "//*[@title='Bosch Profesyonel']")
    public WebElement boschProfesyonelFooter;

    @FindBy(xpath = "//*[@title='Karcher Ürünleri']")
    public WebElement karcherUrunleriFooter;

    @FindBy(xpath = "//*[@title='Alüminyum Ürünler']")
    public WebElement aluminyumUrunlerFooter;

    @FindBy(xpath = "//*[@title='Teknik Spreyler']")
    public WebElement teknikSpreylerFooter;

    @FindBy(xpath = "//*[@title='Çekiç ve Balyozlar']")
    public WebElement cekicVeBalyozlarFooter;

    @FindBy(xpath = "//*[@title='Matkap Uçları']")
    public WebElement matkapUclariFooter;

}
