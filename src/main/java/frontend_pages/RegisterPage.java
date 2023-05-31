package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterPage extends Common {

    @FindBy(xpath = "//span[@class='male']") public WebElement maleButton;
    @FindBy(xpath = "//span[@class='female']") public WebElement femaleButton;
    @FindBy(xpath = "//input[@id='FirstName']") public WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='LastName']") public WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='Email']") public WebElement emailInput;
    @FindBy(xpath = "//input[@id='Password']") public WebElement passwordInput;
    @FindBy(xpath = "//input[@id='ConfirmPassword']") public WebElement confirmPasswordInput;
    @FindBy(xpath = "//button[@id='register-button']") public WebElement registerButton;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']") public WebElement selectDay;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']") public WebElement selectMonth;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']") public WebElement selectYear;
    @FindBy(xpath = "//div[text()='Your registration completed']") public WebElement registrationCompleteText;
    @FindBy(xpath = "//a[@class='button-1 register-continue-button']") public WebElement continueAsRegisteredUserButton;

    public RegisterPage() {PageFactory.initElements(driver, this);}

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            click(maleButton);
        } else {
            click(femaleButton);
        }
    }
    public void enterFirstName(String firstName) {
        type(firstNameInput, firstName);
    }
    public void enterLastName(String lastName) {
        type(lastNameInput, lastName);
    }
    public void enterEmail(String email) {
        type(emailInput, email);
    }
    public void enterPassword(String password) {
        type(passwordInput, password);
    }
    public void enterConfirmPassword(String password) {
        type(confirmPasswordInput, password);
    }
    public void clickRegisterButton() {
        click(registerButton);
    }
    public void selectDay(String day) {
        selectFromDropdown(selectDay, day);
    }
    public void selectMonth(int month) {
        switch (month) {
            case 1:  selectFromDropdown(selectMonth,"January");
                break;
            case 2:  selectFromDropdown(selectMonth,"February");
                break;
            case 3:  selectFromDropdown(selectMonth, "March");
                break;
            case 4:  selectFromDropdown(selectMonth, "April");
                break;
            case 5:  selectFromDropdown(selectMonth, "May");
                break;
            case 6:  selectFromDropdown(selectMonth, "June");
                break;
            case 7:  selectFromDropdown(selectMonth, "July");
                break;
            case 8:  selectFromDropdown(selectMonth, "August");
                break;
            case 9:  selectFromDropdown(selectMonth, "September");
                break;
            case 10: selectFromDropdown(selectMonth, "October");
                break;
            case 11: selectFromDropdown(selectMonth, "November");
                break;
            case 12: selectFromDropdown(selectMonth, "December");
                break;
            default:
                System.out.println("Invalid month");
                break;
        }
    }
    public void selectYear(String year) {
        selectFromDropdown(selectYear, year);
    }
    public String getRegistrationCompletionText() {
        return getTextFromWebElement(registrationCompleteText);
    }

    public void clickContinueAsRegisteredUser() {
        click(continueAsRegisteredUserButton);
    }
}
