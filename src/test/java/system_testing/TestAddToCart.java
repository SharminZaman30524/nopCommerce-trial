package system_testing;

import com.google.common.primitives.Floats;
import frontend_pages.*;
import base.Common;
import io.netty.util.internal.OutOfDirectMemoryError;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAddToCart extends Common {
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    DesktopPage desktopPage;
    WishlistPage wishlistPage;
    OrderDetailsPage orderDetailsPage;

    @Test(enabled = false)
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

    @Test(enabled = true)
    public void testValidAddToCart() throws InterruptedException {
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
        orderDetailsPage = new OrderDetailsPage();
        orderDetailsPage.clickPDFInvoice();
        Thread.sleep(3000);
    }

    @Test (enabled = false)
    public void testAddProductValueOve1000() throws InterruptedException {
        homePage = new HomePage();
        homePage.hoverOverComputersMenuOption();
        homePage.clickDesktopOption();
        desktopPage = new DesktopPage();
        desktopPage.clickAddToWishList("Digital Storm VANQUISH 3 Custom Performance PC");
        Thread.sleep(1000);
        desktopPage.clickAddToWishList("Lenovo IdeaCentre 600 All-in-One PC");
        desktopPage.clickWishlistLink();
        wishlistPage = new WishlistPage();
        wishlistPage.addToCartValueOver1000();
        Thread.sleep(2000);
        wishlistPage.clickAddToCartButton();
        //List<Float> values = new ArrayList<>();
        shoppingCartPage = new ShoppingCartPage();
        for (Float values : shoppingCartPage.getSubtotalValue()) {
            if (values > 1000) {
                Assert.assertTrue(true);
            } else {
                Assert.assertFalse(false);
            }
            Thread.sleep(5000);
        }
    }
}
