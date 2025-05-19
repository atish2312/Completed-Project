package Tests;

import PageObjects.DashBoardPage;
import PageObjects.LandingPage;
import PageObjects.RegisterPage;
import TestComponent.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTest  extends BaseTest {


    @Test
    public void validRegisterTestCase() throws IOException {
        DashBoardPage dashBoardPage = lp.goTo();
        RegisterPage registerPage = dashBoardPage.registerPage();
        registerPage.enterRegisterForm();

    }
}
