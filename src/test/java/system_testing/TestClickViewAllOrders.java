package system_testing;

import admin_pages.*;
import base.Common;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

public class TestClickViewAllOrders extends Common {

    @Test
    public void clickViewAllOrders() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        Thread.sleep(3000);
        loginPage.clickLogin();
        SharedUI sharedUI = new SharedUI();
        Thread.sleep(3000);
        /*try {*/
            sharedUI.selectOption(SharedUI.MenuOption.CATALOG);
            sharedUI.selectOption(SharedUI.MenuOption.ATTRIBUTES);

            //sharedUI.selectSUBOption(SharedUI.MenuOption.CATALOG);
       /* } catch (StaleElementReferenceException ex) {
            sharedUI.selectOption(SharedUI.MenuOption.CATALOG);
        }*/
        Thread.sleep(3000);
    }
}
//SalesPage salesPage = new SalesPage();
//salesPage.clickOrders();

