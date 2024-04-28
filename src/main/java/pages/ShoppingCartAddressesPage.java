package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ShoppingCartAddressesPage {

    private WebElement continueWithTheSelectedAddressButton;
    private WebElement firstAddress;
    private WebDriverWait wait;
    private WebDriver driver;


    public ShoppingCartAddressesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        continueWithTheSelectedAddressButton = driver.findElement(By.cssSelector("div.js-address-form div.clearfix button.btn.btn-primary.continue.float-xs-right"));
        firstAddress = driver.findElement(By.id("id-address-delivery-address-12490"));
    }

    public void selectFirstAddress() {
        if (!firstAddress.isSelected()) {
            firstAddress.click();
        }
    }
    public void clickContinueWithTheSelectedAddressButton() {
        continueWithTheSelectedAddressButton.click();
    }
}