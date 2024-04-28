package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class YourAccountPage {

    private WebElement storeLogoGoToHomePageFromYourAccountPage;
    private WebDriver driver;
    private WebDriverWait wait;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        storeLogoGoToHomePageFromYourAccountPage = driver.findElement(By.xpath("//*[@id=\"_desktop_logo\"]/a/img"));
    }


    public void clickStoreLogoGoToHomePageFromYourAccountPage() {
        storeLogoGoToHomePageFromYourAccountPage.click();
    }

    public void clickOrderHistoryAndDetails() {
        WebElement orderHistoryAndDetails = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#history-link > span > i")));
        orderHistoryAndDetails.click();
    }

}
