package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class ProductHummingbirdPrintedSweaterPage {

    private WebDriver driver;
    private WebElement selectProductSize;
    private WebElement selectProductQuantity;
    private WebElement addToCartButton;
    private WebDriverWait wait;


    public ProductHummingbirdPrintedSweaterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        selectProductSize = driver.findElement(By.id("group_1"));
        selectProductQuantity = driver.findElement(By.id("quantity_wanted"));
        addToCartButton = driver.findElement(By.cssSelector("button.add-to-cart"));
    }

    public void selectProductSize(String size) {
        Select dropdown = new Select(selectProductSize);
        dropdown.selectByVisibleText(size);
    }

    public void setProductQuantity(int quantity) {
        Select dropdown = new Select(selectProductSize);
        String selectedSize = dropdown.getFirstSelectedOption().getText();
        String expectedSize = "size-" + selectedSize.toLowerCase();
        wait.until(ExpectedConditions.urlContains(expectedSize));
        selectProductQuantity.click();
        selectProductQuantity.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        selectProductQuantity.sendKeys(String.valueOf(quantity));
    }

    public void clickAddToCartButton() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.add-to-cart")));
        addToCartButton.click();
    }
}
