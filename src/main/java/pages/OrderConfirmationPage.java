package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class OrderConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement goToYourAccountPageFromOrderConfirmationPage;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        goToYourAccountPageFromOrderConfirmationPage = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]"));
    }

    public void clickGoToYourAccountPageFromOrderConfirmationPage() {
        goToYourAccountPageFromOrderConfirmationPage.click();
    }

    public void takeAScreenshotOfTheOrder(String screenshotPath) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(SrcFile, new File(screenshotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}