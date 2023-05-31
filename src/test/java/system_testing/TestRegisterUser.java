package system_testing;

import base.Common;
import frontend_pages.HomePage;
import frontend_pages.RegisterPage;
import org.bouncycastle.pqc.jcajce.provider.Rainbow;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.GenerateRandomData;

public class TestRegisterUser extends Common {
    String firstName = GenerateRandomData.firstName();
    String lastName = GenerateRandomData.lastName();
    String email = "@gmail.com";
    String password = GenerateRandomData.password();


    HomePage homePage;
    RegisterPage registerPage;
    @Test
    public void testRegisterUser() throws InterruptedException {
        homePage = new HomePage();
        homePage.clickRegister();
        registerPage = new RegisterPage();
        registerPage.selectGender("MaLe");
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(firstName + lastName + email);
        registerPage.selectDay(String.valueOf(GenerateRandomData.day()));
        registerPage.selectMonth(GenerateRandomData.month1to12());
        registerPage.selectYear(String.valueOf(GenerateRandomData.year()));
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickRegisterButton();
        String expectedRegistrationCompleteMessage = "Your registration completed";
        Assert.assertEquals(registerPage.getRegistrationCompletionText(), expectedRegistrationCompleteMessage);

    }
}
