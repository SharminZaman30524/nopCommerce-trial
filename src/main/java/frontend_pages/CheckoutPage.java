package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends Common {
    @FindBy(xpath = "//input[@id='BillingNewAddress_FirstName']")
    public WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='BillingNewAddress_LastName']")
    public WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='BillingNewAddress_Email']")
    public WebElement emailInput;
    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
    public WebElement countryDropdown;
    @FindBy(xpath = "//select[@id='BillingNewAddress_StateProvinceId']")
    public WebElement stateDropdown;
    @FindBy(xpath = "//input[@id='BillingNewAddress_City']")
    public WebElement inputCity;
    @FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
    public WebElement inputAddress;
    @FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
    public WebElement inputZipCode;
    @FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
    public WebElement inputPhoneNumber;
    @FindBy(xpath = "//button[@class='button-1 new-address-next-step-button']")
    public WebElement billingAddressContinueButton;
    @FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
    public WebElement shippingMethodContinueButton;
    @FindBy(xpath = "//button[@class='button-1 payment-method-next-step-button']")
    public WebElement paymentMethodContinueButton;
    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    public WebElement paymentInformationContinueButton;
    @FindBy(xpath = "//button[@class='button-1 confirm-order-next-step-button']")
    public WebElement confirmOrderButton;
    @FindBy(xpath = "//a[text()='Click here for order details.']")
    public WebElement orderDetailsLink;

    public CheckoutPage() {PageFactory.initElements(driver, this);}
    public void enterFirstName(String firstName) {
        type(firstNameInput, firstName);
    }
    public void enterLastName(String lastName) {
        type(lastNameInput, lastName);
    }
    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void selectCountry(String country) {
        selectFromDropdown(countryDropdown,country);
    }
    public void selectState(String state) {
        wait.until(ExpectedConditions.visibilityOf(stateDropdown));
        selectFromDropdown(stateDropdown,state);
    }
    public void enterCity(String city) {
        type(inputCity, city);
    }
    public void enterAddress(String address) {
        type(inputAddress, address);
    }
    public void enterZipCode(String zipCode) {
        type(inputZipCode, zipCode);
    }
    public void enterPhoneNumber(String phoneNumber) {
        type(inputPhoneNumber, phoneNumber);
    }
    public void clickBillingAddressContinueButton() {
        click(billingAddressContinueButton);
    }
    public void clickShippingMethodContinueButton() {
        click(shippingMethodContinueButton);
    }
    public void clickPaymentMethodContinueButton() {
        click(paymentMethodContinueButton);
    }
    public void clickPaymentInformationContinueButton() {
        click(paymentInformationContinueButton);
    }
    public void clickConfirmOrderButton() {
        click(confirmOrderButton);
    }
    public void clickorderDetails() {
        click(orderDetailsLink);
    }


}
