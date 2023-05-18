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
        MenuOption dashboard = MenuOption.DASHBOARD;
        MenuOption catalog = MenuOption.CATALOG;
        MenuOption attributes = MenuOption.ATTRIBUTES;
        MenuOption sales = MenuOption.SALES;
        MenuOption customers = MenuOption.CUSTOMERS;

        //wait.until(ExpectedConditions.visibilityOfAllElements(listMenuOptions));
        for (WebElement element : listMenuOptions) {
            if (element.getText().equalsIgnoreCase(dashboard.toString())) {
                click(element);
            } else if (element.getText().equalsIgnoreCase(customers.toString())) {
                click(element);
            } else if (element.getText().equalsIgnoreCase(attributes.toString())) {
                click(element);
            } /*else if (element.getText().equalsIgnoreCase(catalog.toString())) {
                click(element);
            }*/
        }
    }
}
//(element.getText().equalsIgnoreCase(option.toString()))

/*switch (option) {
                case SALES:
                    element.getText().equalsIgnoreCase(sales.toString());
                    click(element);
                    break;
                case CATALOG:
                    element.getText().equalsIgnoreCase(catalog.toString());
                    click(element);
                    break;
                case CUSTOMERS:
                    element.getText().equalsIgnoreCase(customers.toString());
                    click(element);
                    break;*/