package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PaymentMethodPage {

    private WebElement payByCheckMethodButton;
    private WebElement agreeToTheTermsOfServiceCheckbox;
    private WebElement placeOrderButton;
    private WebDriverWait wait;
    private WebDriver driver;


    public PaymentMethodPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        payByCheckMethodButton = driver.findElement(By.id("payment-option-1"));
        agreeToTheTermsOfServiceCheckbox = driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]"));
        placeOrderButton = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
    }

    public void selectPayByCheckMethod() {
        if (!payByCheckMethodButton.isSelected()) {
            payByCheckMethodButton.click();
        }
    }

    public void clickAgreeToTheTermsOfServiceCheckbox() {
        if (!agreeToTheTermsOfServiceCheckbox.isSelected()) {
            agreeToTheTermsOfServiceCheckbox.click();
        }
    }

    private void waitForElementToBeClickable(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
}
    public void clickPlaceOrderButton() {
        waitForElementToBeClickable(placeOrderButton);
        placeOrderButton.click();
    }
}