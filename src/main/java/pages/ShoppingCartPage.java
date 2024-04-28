package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ShoppingCartPage {

    private WebElement proceedToCheckoutButton;
    private WebDriverWait wait;
    private WebDriver driver;


    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        proceedToCheckoutButton = driver.findElement(By.cssSelector("div.cart-summary > div.checkout.cart-detailed-actions > div > a"));

    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}