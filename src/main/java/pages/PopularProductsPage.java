package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopularProductsPage {

    private WebElement productHummingbirdPrintedSweater;
    private WebDriverWait wait;
    private WebDriver driver;

    public PopularProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productHummingbirdPrintedSweater = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div[2]/article/div/div[1]/a/img"));
    }

    public void selectProductHummingbirdPrintedSweater() {
        productHummingbirdPrintedSweater.click();
    }
}
