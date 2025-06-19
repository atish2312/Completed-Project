package Tests;

import PageObjects.DashBoardPage;
import PageObjects.LoginPage;
import TestComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static CommonMethods.AbstractMethods.userEmail;
import static CommonMethods.AbstractMethods.userPassword;

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
        loginPage.enterCredentials(userEmail,userPassword);
        loginPage.verifyMyAccountPage();
    }
    @Test(priority = 2)
    public void invalidCredentials(){

        String password = "Atish123!";
        String email = "atish"+userPassword;
        loginPage.enterCredentials(email,userPassword);
        Assert.assertTrue(loginPage.errorDisplay());
    }
}
