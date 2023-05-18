package system_testing;

import frontend_pages.HomePage;
import base.Common;
import org.testng.annotations.Test;

public class TestClickElectronics extends Common {
    HomePage homePage;
    @Test
    public void clickAdmin() {
        homePage = new HomePage();
        homePage.clickElectronics();
    }
}
