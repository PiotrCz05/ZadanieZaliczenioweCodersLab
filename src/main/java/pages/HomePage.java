package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    private WebElement signInLink;
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        signInLink = driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a/span"));
    }

    public void clickSignInLink() {
        signInLink.click();
    }

}
