import com.seleniumTest.pages.*;
import com.seleniumTest.users.User;
import com.seleniumTest.users.UserPool;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCases extends BaseTest {

    @Test
    public void shouldLogin() throws InterruptedException {

        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.getLoginPage();
        User user = UserPool.getUser1();
        loginPage.login(user);

        String accountButtonText = homePage.getAccountText();
        assertEquals(accountButtonText, "Test Hesap");

        //search
        SearchPage searchPage = new SearchPage(webDriver);
        String bookName = searchPage.sendText("nutuk");
        assertEquals("nutuk", bookName);

        //product
        ProductPage productPage = new ProductPage(webDriver);
        String addBasketTestControl = productPage.clickProduct();
        assertEquals("Ürün sepete eklendi", addBasketTestControl);


        //basket page
        BasketPage basketPage = new BasketPage(webDriver);
        basketPage.getBasketPageDetail();
        String basketPageControl = basketPage.basketPageControl();

        assertEquals("Sepetim", basketPageControl);

        String deliveryAddres = basketPage.completeShoppingButton();
        assertEquals("Teslimat adresi", deliveryAddres);

        //address continue
        String paymentPageControl = basketPage.addressContinueButton();
        assertEquals("Ödeme yöntemleri", paymentPageControl);

        //Bank check
        PaymentManagementPage paymentManagement = new PaymentManagementPage(webDriver);
        paymentManagement.selectInstantRemittance();

        String selectBank = paymentManagement.clickBank();
        String checkBankSummaryPage = paymentManagement.continueButton();
        assertEquals(selectBank, checkBankSummaryPage);

    }

}
