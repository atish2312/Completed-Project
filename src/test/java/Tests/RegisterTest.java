package Tests;

import CommonMethods.AbstractMethods;
import PageObjects.DashBoardPage;
import PageObjects.LandingPage;
import PageObjects.RegisterPage;
import TestComponent.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTest  extends BaseTest {


    @Test(priority = 1)
    public void validRegisterTestCase() throws IOException {
        DashBoardPage dashBoardPage = lp.goTo();
        test.log(Status.INFO,"Starting the valid test case");
        RegisterPage registerPage = dashBoardPage.registerPage();
        registerPage.enterRegisterForm(userFirstName,userLastName,userEmail,userPhoneNumber,userPassword);
        test.log(Status.INFO,"Enter the enter first name"+ userFirstName);
        test.log(Status.INFO,"Enter the enter last name" + userLastName);
        test.log(Status.INFO,"The email is "+ userEmail);
        Assert.assertEquals(registerPage.gettext(),"Congratulations! Your new account has been successfully created!");
    }
    @Test(priority = 2)
    public void emailAlreadyRegistered(){
        DashBoardPage dashBoardPage = lp.goTo();
        test.log(Status.INFO,"Starting the valid test case");
        RegisterPage registerPage = dashBoardPage.registerPage();
        registerPage.enterRegisterForm(userFirstName,userLastName,userEmail,userPhoneNumber,userPassword);
        test.log(Status.INFO,"Enter the enter first name"+ userFirstName);
        test.log(Status.INFO,"Enter the enter last name" + userLastName);
        test.log(Status.INFO,"The email is "+ userEmail);
        Assert.assertTrue(registerPage.isDisplay());
    }
    }

