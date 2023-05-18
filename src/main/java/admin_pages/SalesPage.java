package admin_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesPage extends SharedUI{
    @FindBy(xpath = "//li[@class='nav-item']//a[@href='/Admin/Order/List']") public WebElement linkOrders;

    public SalesPage() {PageFactory.initElements(driver, this);}

    public void clickOrders() {
        click(linkOrders);
    }
}
