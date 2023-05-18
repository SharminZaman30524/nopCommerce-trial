package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Common {
    @FindBy(xpath = "//a[@href='/electronics']")
    public WebElement electronicsLink;

    public HomePage() {PageFactory.initElements(driver, this);}

    public void clickElectronics() {
        electronicsLink.click();
    }

}


