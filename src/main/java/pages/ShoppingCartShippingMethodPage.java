package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ShoppingCartShippingMethodPage {

    private WebElement selfPickUpMethodButton;
    private WebElement continueWithTheSelectedShippingMethodButton;
    private WebDriver driver;
    private WebDriverWait wait;

    public ShoppingCartShippingMethodPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        selfPickUpMethodButton = driver.findElement(By.xpath("//*[@id=\"delivery_option_8\"]"));
        continueWithTheSelectedShippingMethodButton = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
    }

    public void selectSelfPickUpMethod() {
        if (!selfPickUpMethodButton.isSelected()) {
            selfPickUpMethodButton.click();
        }
    }

    public void clickcontinueWithTheSelectedShippingMethodButton() {
        continueWithTheSelectedShippingMethodButton.click();
    }


}