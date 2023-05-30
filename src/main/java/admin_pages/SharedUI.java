package admin_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SharedUI extends Common {
    public enum MenuOption {
        DASHBOARD,
        CATALOG,
        ATTRIBUTES,
        SALES,
        CUSTOMERS,
        PROMOTIONS,
        CONTENT_MANAGEMENT,
        CONFIGURATION,
        SETTINGS,
        SHIPPING,
        POS,
        AUTHENTICATION,
        SYSTEM,
        REPORTS,
        HELP
    }

    @FindBy(xpath = "//li[@class='nav-item has-treeview']")
    public List<WebElement> listMenuOptions;

    public SharedUI() {
        PageFactory.initElements(driver, this);
    }

    public void selectOption(MenuOption option) {
        //wait.until(ExpectedConditions.visibilityOfAllElements(listMenuOptions));
        for (WebElement element : listMenuOptions) {
            if (element.getText().equalsIgnoreCase(option.toString())) {
                click(element);

            }
        }
    }
}
