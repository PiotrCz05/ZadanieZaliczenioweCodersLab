package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductSuccessfullyAddedToCartPopUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductSuccessfullyAddedToCartPopUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickProceedToCheckoutButton() {
        WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cart-content-btn']/a[@class='btn btn-primary']")));
        proceedToCheckoutButton.click();
    }
}
