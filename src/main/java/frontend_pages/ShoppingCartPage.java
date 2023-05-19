package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends Common {
    @FindBy(xpath = "//input[@class='qty-input']")
    public WebElement updateQuantityInput;
    @FindBy(xpath = "//button[@class='button-2 update-cart-button']")
    public WebElement updateShoppingCartButton;
    @FindBy(xpath = "//input[@name='discountcouponcode']")
    public WebElement discountInput;

    @FindBy(xpath = "//div[@class='terms-of-service']//input[@type='checkbox']")
    public WebElement termsOfServicesCheckBox;
    /*@FindBy(xpath = "//input[@data-gtm-form-interact-field-id='0']")
    public WebElement termsOfServicesCheckBox;*/
    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkoutButton;
    @FindBy(xpath = "//button[@class='button-1 checkout-as-guest-button']")
    public WebElement checkoutAsAGuestButton;

    public ShoppingCartPage() {PageFactory.initElements(driver,this);}

    public void enterUpdatedQuantity(String quantity) {
        updateQuantityInput.clear();
        type(updateQuantityInput, quantity);
    }
    public void clickUpdateShoppingCartButton() {
        click(updateShoppingCartButton);
    }
    public void enterDiscountCode(String discount) {
        type(discountInput, discount);
    }

    public void checkTermsOfServicesCheckBox() {
        wait.until(ExpectedConditions.visibilityOf(termsOfServicesCheckBox));
        click(termsOfServicesCheckBox);
    }
    public void clickCheckout() {
        click(checkoutButton);
    }
    public void clickCheckoutAsAGuest() {
        click(checkoutAsAGuestButton);
    }

}
