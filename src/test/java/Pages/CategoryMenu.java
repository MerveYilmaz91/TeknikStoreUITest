package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CategoryMenu extends ParentPage {

    public CategoryMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[title='İş sağlığı Güvenliği']")
    public WebElement kategori;

    @FindBy(xpath = "(//div[@class='showcase-title'])[1]")
    public WebElement selectFirstItem;

    @FindBy(xpath = "//span[contains(text(),'Sepetim')]")
    public WebElement myCartButton;

    @FindBy(css = "span[class='cart-list-item-amount']")
    public WebElement productAmount;

    @FindBy(css = "div[class='col-lg-auto'] select")
    public WebElement filterDropdown;

    @FindBy(css = "div[class='showcase-price-new']")
    public List<WebElement> productPriceList;

    @FindBy(css = "div[class='discount-label']")
    public List<WebElement> productDiscountRates;

    @FindBy(css = "div[class='category-level-1']")
    public WebElement tabContainer;

    @FindBy(css = "li[class='has-sub-category']") // Tüm sekme butonları
    public List<WebElement> tabButtons;

    @FindBy(css = "div[class='showcase']")
    public List<WebElement> productCards;

    @FindBy(css = "a[href='/indirimli-urunler']")
    public WebElement indirimliUrunlerButonu;

    @FindBy(css = "div[class='navigation-container']")
    public WebElement tumKategoriler;

    public void selectSortOption(String optionText) {
        wait.until(ExpectedConditions.elementToBeClickable(filterDropdown));
        ParentPage.scrollToElement(filterDropdown);

        Select select = new Select(filterDropdown);
        select.selectByVisibleText(optionText);

        try {
            Thread.sleep(2000);

            wait.until(ExpectedConditions.visibilityOfAllElements(productCards));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Double> getProductPrices() {
        if (!productPriceList.isEmpty()) {
            wait.until(ExpectedConditions.visibilityOf(productPriceList.get(0)));
        }

        List<Double> prices = new ArrayList<>();
        for (WebElement element : productPriceList) {
            String priceText = element.getText().replaceAll("[^0-9,]", "").replace(",", ".");
            if (!priceText.isEmpty()) {
                prices.add(Double.parseDouble(priceText));
            }
        }
        return prices;
    }

    public List<Integer> getProductDiscountRates() {
        List<Integer> rates = new ArrayList<>();
        for (WebElement element : productDiscountRates) {
            String rateText = element.getText().replaceAll("[^0-9]", "");
            if (!rateText.isEmpty()) {
                rates.add(Integer.parseInt(rateText));
            }
        }
        return rates;
    }

    public boolean isListSortedAscending(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isListSortedDescending(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isIntegerListSortedDescending(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isProductListDisplayedAndNotEmpty() {
        return !productCards.isEmpty() && productCards.get(0).isDisplayed();
    }

    // US-17
    public boolean isTabContainerVisible() {
        wait.until(ExpectedConditions.visibilityOf(tabContainer));
        return tabContainer.isDisplayed();
    }

    public void clickProductTab(String tabName) {
        if (tabName.toUpperCase().contains("İNDİRİM") || tabName.contains("ndirim")) {
            System.out.println("Sitedeki kırmızı İNDİRİMLİ ÜRÜNLER butonuna tıklanıyor...");
             ParentPage.myClick(indirimliUrunlerButonu);
            return;
        }

        boolean sekmeBulundu = false;

        if (tabButtons != null && !tabButtons.isEmpty()) {
            for (WebElement tab : tabButtons) {
                if (tab.getText().trim().toLowerCase().contains(tabName.toLowerCase())) {
                    ParentPage.myClick(tab);
                    sekmeBulundu = true;
                    try { Thread.sleep(1500); } catch (InterruptedException e) {}
                    break;
                }
            }
        }

        // Sitede o sekmeler olmadığı için "sekmeBulundu" false kalacak ve test haklı olarak patlayacak:
        org.testng.Assert.assertTrue(sekmeBulundu, "BUG BULUNDU: Sitede '" + tabName + "' isminde bir sekme mevcut değil!");
    }

    public boolean isTabActive(String tabName) {
        try { Thread.sleep(1500); } catch (InterruptedException e) {}

        // İndirimli ürünler için URL kontrolü
        if (tabName.toUpperCase().contains("İNDİRİM") || tabName.contains("ndirim")) {
            String currentUrl = GWD.getDriver().getCurrentUrl().toLowerCase();
            return currentUrl.contains("indirimli-urunler");
        }

        // Diğer sekmeler (Sitede olmadığı için zaten buraya gelmeden tıklama adımında test FAILED olacak)
        return false;
    }
    public int getVisibleProductCount() {
        return productCards.size();
    }

                                         // --- Verification Methods ---

    public boolean verifyAllProductCardElements() {

        if (productCards.isEmpty()) return false;

        System.out.println("Ekranda Bulunan Toplam Ürün Sayısı: " + productCards.size());

        for (int i = 0; i < productCards.size(); i++) {
            WebElement card = productCards.get(i);
            boolean hasImage = !card.findElements(By.cssSelector("img[loading='lazy']")).isEmpty();
            boolean hasTitle = !card.findElements(By.cssSelector("div.showcase-title")).isEmpty();
            boolean hasPrice = !card.findElements(By.cssSelector("div.showcase-price-new")).isEmpty();
            boolean hasButton = !card.findElements(By.cssSelector("a.add-to-cart-button")).isEmpty();

            System.out.println((i + 1) + ". Kart -> Resim: " + hasImage + " | Marka: " +
                     hasTitle + " | Fiyat: " + hasPrice + " | Buton: " + hasButton);

            if (!(hasImage && hasTitle && hasPrice && hasButton)) {
                System.out.println("HATA: " + (i + 1) + ". üründe eksik alanlar tespit edildi!");
                return false;
            }
        }
        System.out.println("Tüm ürün kartları başarıyla doğrulandı!");
        return true;
    }

    public boolean verifyDiscountLabels() {
        if (productCards.isEmpty()) return false;

        for (int i = 0; i < productCards.size(); i++) {
            WebElement card = productCards.get(i);
            boolean hasSalePrice = !card.findElements(By.cssSelector(".showcase-price-new")).isEmpty();
            boolean hasDiscountBadge = !card.findElements(By.cssSelector(".discount-label")).isEmpty();

            System.out.println((i + 1) + ". Ürün -> İndirimli Fiyat Var Mı: " + hasSalePrice + " | İndirim Oranı Var Mı: " + hasDiscountBadge);

            if (!hasSalePrice && !hasDiscountBadge) {
                System.out.println("HATA: " + (i + 1) + ". üründe ne indirimli fiyat ne de indirim etiketi bulunabildi!");
                return false;
            }
        }
        return true;
    }
}





