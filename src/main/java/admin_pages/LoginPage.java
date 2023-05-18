package admin_pages;

import base.Common;
import lombok.extern.java.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Common {
    @FindBy(xpath = "//button[@type='submit']") public WebElement buttonLogin;

    public LoginPage() {PageFactory.initElements(driver, this);}

    public void clickLogin() {
        click(buttonLogin);
    }
}
