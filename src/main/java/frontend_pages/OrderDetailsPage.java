package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage extends Common {
    @FindBy(xpath = "//a[text()='PDF Invoice']") public WebElement pdfInvoiceButton;

    public OrderDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickPDFInvoice() {
        click(pdfInvoiceButton);
    }

}
