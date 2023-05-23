package system_testing;

import base.Common;
import frontend_pages.DesktopPage;
import frontend_pages.HomePage;
import frontend_pages.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddToWishList extends Common {
    HomePage homePage;
    DesktopPage desktopPage;
    WishlistPage wishlistPage;
    @Test
    public void testValidAddToWishList() throws InterruptedException {
        homePage = new HomePage();
        homePage.hoverOverComputersMenuOption();
        homePage.clickDesktopOption();
        desktopPage = new DesktopPage();
        desktopPage.clickAddToWishList("Digital Storm VANQUISH 3 Custom Performance PC");
        Thread.sleep(1000);
        desktopPage.clickAddToWishList("Lenovo IdeaCentre 600 All-in-One PC");
        desktopPage.clickWishlistLink();
        wishlistPage= new WishlistPage();
        wishlistPage.getProductNameFromWishList();
        Assert.assertTrue(wishlistPage.getProductNameFromWishList().contains("Digital Storm VANQUISH 3 Custom Performance PC") && wishlistPage.getProductNameFromWishList().contains("Lenovo IdeaCentre 600 All-in-One PC"));
    }
}
