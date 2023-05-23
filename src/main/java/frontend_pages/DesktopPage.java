package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Common {
    @FindBy(xpath = "//button[@class='button-2 add-to-wishlist-button']") public List<WebElement> wishlistButton;
    @FindBy(xpath = "//h2[@class='product-title']") public List<WebElement> listProductNames;
    @FindBy(xpath = "//a[@href='/wishlist']") public WebElement wishListLink;
    public DesktopPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickAddToWishList(String productName) {
        for(WebElement element: listProductNames) {
            if(element.getText().equalsIgnoreCase(productName)) {
                click(wishlistButton.get(listProductNames.indexOf(element)));
            }
        }
    }
    /*public void clickAddToWishList(int index) {
       click(wishlistButton.get(index));
    }*/
    public void clickWishlistLink() {
        click(wishListLink);
    }

}
