package admin_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends SharedUI {
    @FindBy(xpath = "//a[@class='btn btn-xs btn-info btn-flat margin-l-10']") public WebElement linkViewAllOrder;

    public DashboardPage() {PageFactory.initElements(driver, this);}

    public void clickViewAllOrdersLink() {
        linkViewAllOrder.click();
    }
}
