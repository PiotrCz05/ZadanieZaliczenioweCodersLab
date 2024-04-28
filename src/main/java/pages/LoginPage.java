package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement signInButton;
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        emailInput = driver.findElement(By.id("field-email"));
        passwordInput = driver.findElement(By.id("field-password"));
        signInButton = driver.findElement(By.id("submit-login"));
    }

    public void typeEmailAddress() {
        emailInput.sendKeys("rafallafar@zadanie1.com");
    }

    public void typePassword() {
        passwordInput.sendKeys("123456789");
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}