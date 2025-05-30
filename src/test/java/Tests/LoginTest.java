package Tests;

import PageObjects.DashBoardPage;
import PageObjects.LoginPage;
import TestComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    protected LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        DashBoardPage dashBoardPage = lp.goTo();
         loginPage = dashBoardPage.loginPage();
    }
    @Test(priority = 1)
    public void validLoginCredential() {
        String email = "Atish123@yopmail.com";
        String password = "Atish123!";
        loginPage.enterCredentials(email,password);
        loginPage.verifyMyAccountPage();
    }
    @Test(priority = 2)
    public void invalidCredentials(){
        String email = "Atish12@yopmail.com"; //Wrong mail
        String password = "Atish123!";
        loginPage.enterCredentials(email,password);
        Assert.assertTrue(loginPage.errorDisplay());
    }
}
