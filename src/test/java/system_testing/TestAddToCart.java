package system_testing;

import frontend_pages.CheckoutPage;
import frontend_pages.HomePage;
import base.Common;
import frontend_pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddToCart extends Common {
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    @Test(enabled=false)
    public void testInvalidQuantityAddToCart() throws InterruptedException {
        homePage = new HomePage();
        homePage.hoverOverComputersMenuOption();
        homePage.clickNotebooksOption();
        homePage.clickMacbookPro13InchLink();
        homePage.enterItemQuantity("1");
        homePage.clickAddToCart();
        Thread.sleep(3000);
        String expectedQuantityErrorMessage = "The minimum quantity allowed for purchase is 2.";
        Assert.assertEquals(homePage.minimumPurchaseErrorNotification.getText(), expectedQuantityErrorMessage);
        homePage.clickCloseNotification();
        Thread.sleep(3000);
    }
    @Test
    public void testAddToCart() throws InterruptedException {
        homePage = new HomePage();
        homePage.hoverOverComputersMenuOption();
        homePage.clickNotebooksOption();
        homePage.clickMacbookPro13InchLink();
        homePage.clickAddToCart();
        homePage.clickShoppingCartNotification();
        shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.checkTermsOfServicesCheckBox();
        shoppingCartPage.clickCheckout();
        shoppingCartPage.clickCheckoutAsAGuest();
        checkoutPage = new CheckoutPage();
        checkoutPage.enterFirstName("Sharmin");
        checkoutPage.enterLastName("Zaman");
        checkoutPage.enterEmail("zamansharmin000@gmail.com");
        checkoutPage.selectCountry("United States");
        Thread.sleep(3000);
        checkoutPage.selectState("New York");
        checkoutPage.enterCity("Queens");
        checkoutPage.enterAddress("Shometheifjew");
        checkoutPage.enterZipCode("12344");
        checkoutPage.enterPhoneNumber("234567654321");
        checkoutPage.clickBillingAddressContinueButton();
        checkoutPage.clickShippingMethodContinueButton();
        checkoutPage.clickPaymentMethodContinueButton();
        checkoutPage.clickPaymentInformationContinueButton();
        checkoutPage.clickConfirmOrderButton();
        checkoutPage.clickorderDetails();
        Thread.sleep(3000);
    }

}
