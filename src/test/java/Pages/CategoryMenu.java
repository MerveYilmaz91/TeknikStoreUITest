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

    @FindBy(css = "a[title*='FREEDOM']:nth-of-type(2)")
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
    //--
    @FindBy(css = "div[class='category-level-1']")
    public WebElement tabContainer;

    @FindBy(css = "li[class='has-sub-category']") // Tüm sekme butonları
    public List<WebElement> tabButtons;

    @FindBy(css = "div[class='showcase']")
    public List<WebElement> productCards;

    @FindBy(css = "a[href='/indirimli-urunler']")
    public WebElement indirimliUrunlerButonu;

    public void selectSortOption(String optionText) {
        wait.until(ExpectedConditions.elementToBeClickable(filterDropdown));
        ParentPage.scrollToElement(filterDropdown); // Ekranda dropdown'a kaydır

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
        if (tabName.toLowerCase().contains("indirim")) {
            ParentPage.myClick(indirimliUrunlerButonu);
            try { Thread.sleep(1500); } catch (InterruptedException e) {}
            return;
        }

        for (WebElement tab : tabButtons) {
            if (tab.getText().trim().equalsIgnoreCase(tabName)) {
                ParentPage.scrollToTop();
                ParentPage.myClick(tab);
                try { Thread.sleep(1500); } catch (InterruptedException e) {}
                break;
            }
        }
    }

    public boolean isTabActive(String tabName) {
        try { Thread.sleep(1500); } catch (InterruptedException e) {}

        if (tabName.toLowerCase().contains("indirim")) {
            String currentUrl = GWD.getDriver().getCurrentUrl();
            if (currentUrl.contains("indirim")) {
                return true;
            }
            return false;
        }

        for (WebElement tab : tabButtons) {
            String okunanMetin = tab.getText().trim();
            if (okunanMetin.toLowerCase().contains(tabName.toLowerCase())) {
                String elementClass = tab.getAttribute("class");
                if (elementClass != null && elementClass.contains("active")) return true;

                try {
                    String parentClass = tab.findElement(By.xpath("./..")).getAttribute("class");
                    if (parentClass != null && parentClass.contains("active")) return true;
                } catch (Exception e) {}
            }
        }
        return false;
    }
    public int getVisibleProductCount() {
        return productCards.size();
    }

                                         // --- Verification Methods ---

    public boolean verifyAllProductCardElements() {

        if (productCards.isEmpty()) return false;

        for (WebElement card : productCards) {
            boolean hasImage = !card.findElements(By.cssSelector("img[loading='lazy']")).isEmpty();
            boolean hasTitle = !card.findElements(By.cssSelector("div.showcase-title")).isEmpty();
            boolean hasPrice = !card.findElements(By.cssSelector("div.showcase-price-new")).isEmpty();
            boolean hasButton = !card.findElements(By.cssSelector("a.add-to-cart-button")).isEmpty();

            if (!(hasImage && hasTitle && hasPrice && hasButton)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyDiscountLabels() {
        if (productCards.isEmpty()) return false;

        for (WebElement card : productCards) {
            boolean hasSalePrice = !card.findElements(By.cssSelector(".showcase-price-new")).isEmpty();
            boolean hasDiscountBadge = !card.findElements(By.cssSelector(".discount-label")).isEmpty();

            if (!hasSalePrice && !hasDiscountBadge) {
                return false;
            }
        }
        return true;
    }
}





