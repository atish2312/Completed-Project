package Tests;

import PageObjects.DashBoardPage;
import PageObjects.LandingPage;
import PageObjects.RegisterPage;
import TestComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTest  extends BaseTest {


    @Test
    public void validRegisterTestCase() throws IOException {
        DashBoardPage dashBoardPage = lp.goTo();
        RegisterPage registerPage = dashBoardPage.registerPage();
        registerPage.enterRegisterForm("Atish","Kumar","Atish@yopmail.com","+91977797979","Atish123!","Atish123!");
        Assert.assertEquals(registerPage.gettext(),"Congratulations! Your new account has been successfully created!");
    }
    @Test
    public void emailAlreadyRegistered(){
        DashBoardPage dashBoardPage = lp.goTo();
        RegisterPage registerPage = dashBoardPage.registerPage();
        registerPage.enterRegisterForm("Atish","Kumar","Atish@yopmail.com","+91977797979","Atish123!","Atish123!");
        Assert.assertTrue(registerPage.isDisplay());

    }


    }

