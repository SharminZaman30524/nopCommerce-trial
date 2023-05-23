package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class WishlistPage extends Common {
    @FindBy(xpath = "//td[@class='product']//a")
    public List<WebElement> wishListProducts;
    @FindBy(xpath = "//td[@class='add-to-cart']")
    public List<WebElement> wishListAddToCartCheckbox;
    @FindBy(xpath = "//td[@class='subtotal']")
    public List<WebElement> wishListSubtotals;
    @FindBy(xpath = "//button[@name='addtocartbutton']")
    public WebElement addToCartButton;


    public WishlistPage() {
        PageFactory.initElements(driver, this);
    }

    public List<String> getProductNameFromWishList() {
        List<String> productNames = new ArrayList<>();
        for (WebElement element : wishListProducts) {
            productNames.add(getTextFromWebElement(element));
        }return productNames;
    }

    public void addToCartValueOver1000() {
        for(WebElement element: wishListSubtotals) {
            if(Float.parseFloat(getTextFromWebElement(element).substring(1).replace(",",""))>1000) {
                click(wishListAddToCartCheckbox.get(wishListSubtotals.indexOf(element)));
            }
        }
    }

    public void clickAddToCartButton() {
        click(addToCartButton);
    }
}
