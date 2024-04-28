package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderHistoryPage {

    private WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String[] getLastOrderInfo() {
        List<WebElement> orderElements = driver.findElements(By.xpath("//*[@id=\"content\"]/table"));
            WebElement lastOrderElement = orderElements.get(0);
            WebElement statusElement = lastOrderElement.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[4]/span"));
            WebElement totalPriceElement = lastOrderElement.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[2]"));
            String orderStatus = statusElement.getText();
            String totalPrice = totalPriceElement.getText();
        return new String[] {orderStatus, totalPrice};
    }
}