package Pages;

import StepDefinitions.Hooks;
import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParentPage {

    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    public static void myClick(WebElement element) {
        Hooks.setLastUsedElement(element);
        scrollToElement(element);
        element.click();
    }

    public static void mySendKeys(WebElement element, String text) {
        Hooks.setLastUsedElement(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }


    public static void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
