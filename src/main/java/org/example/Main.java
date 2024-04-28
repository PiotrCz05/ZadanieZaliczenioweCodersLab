package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

public class Main {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("force-device-scale-factor=1.2");
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.manage().window().maximize();
            // 1. Wejdź na stronę główną
            driver.get("https://mystore-testlab.coderslab.pl/index.php");
            // 2. Kliknij w link SignIn
            HomePage homePage = new HomePage(driver);
            homePage.clickSignInLink();
            // 3. Zaloguj się na konto użytkownika
            // E-mail: rafallafar@zadanie1.com hasło: 123456789
            LoginPage loginPage = new LoginPage(driver);
            loginPage.typeEmailAddress();
            loginPage.typePassword();
            loginPage.clickSignInButton();
            // 4. Wybierz do zakupu Hummingbird Printed Sweater
            YourAccountPage yourAccountPage = new YourAccountPage(driver);
            yourAccountPage.clickStoreLogoGoToHomePageFromYourAccountPage();
            PopularProductsPage popularProductsPage = new PopularProductsPage(driver);
            popularProductsPage.selectProductHummingbirdPrintedSweater();
            // 5. Wybierz rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
            ProductHummingbirdPrintedSweaterPage productHummingbirdPrintedSweaterPage = new ProductHummingbirdPrintedSweaterPage(driver);
            productHummingbirdPrintedSweaterPage.selectProductSize("M");
            // 6. Wybierz 5 sztuk według parametru podanego w teście
            // (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
            productHummingbirdPrintedSweaterPage.setProductQuantity(5);
            // 7. Dodaj produkt do koszyka,
            productHummingbirdPrintedSweaterPage.clickAddToCartButton();
            // 8. Przejdź do opcji - checkout,
            ProductSuccessfullyAddedToCartPopUpPage productSuccessfullyAddedToCartPopUpPage = new ProductSuccessfullyAddedToCartPopUpPage(driver);
            productSuccessfullyAddedToCartPopUpPage.clickProceedToCheckoutButton();
            // 9. Potwierdź address,
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            shoppingCartPage.clickProceedToCheckoutButton();
            ShoppingCartAddressesPage shoppingCartAddressesPage = new ShoppingCartAddressesPage(driver);
            shoppingCartAddressesPage.selectFirstAddress();
            shoppingCartAddressesPage.clickContinueWithTheSelectedAddressButton();
            // 10. Wybierz metodę odbioru - PrestaShop "pick up in store",
            ShoppingCartShippingMethodPage shoppingCartShippingMethodPage = new ShoppingCartShippingMethodPage(driver);
            shoppingCartShippingMethodPage.selectSelfPickUpMethod();
            shoppingCartShippingMethodPage.clickcontinueWithTheSelectedShippingMethodButton();
            // 11. Wybierz opcję płatności - Pay by Check,
            PaymentMethodPage paymentMethodPage = new PaymentMethodPage(driver);
            paymentMethodPage.selectPayByCheckMethod();
            paymentMethodPage.clickAgreeToTheTermsOfServiceCheckbox();
            // 12. Kliknij na "order with an obligation to pay",
            paymentMethodPage.clickPlaceOrderButton();
            // 13. Zrób screnshota,
            OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
            orderConfirmationPage.takeAScreenshotOfTheOrder("src/main/resources/screenshot.png");
            // 14. Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
            orderConfirmationPage.clickGoToYourAccountPageFromOrderConfirmationPage();
            yourAccountPage.clickOrderHistoryAndDetails();
            // 15. Sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą
            OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
            String[] orderInfo = orderHistoryPage.getLastOrderInfo();
            String lastOrderStatus = orderInfo[0];
            String totalPrice = orderInfo[1];
            System.out.println("Status ostatniego zamówienia: " + lastOrderStatus);
            System.out.println("Kwota: " + totalPrice);
        } finally {
            driver.quit();
        }
    }
}