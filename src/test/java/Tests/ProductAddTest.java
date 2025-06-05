package Tests;

import PageObjects.AddDeviceToCart;
import PageObjects.DashBoardPage;
import TestComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class ProductAddTest extends BaseTest {

    @Test
    public void validProduct() throws InterruptedException, AWTException {
        String image = System.getProperty("user.dir")+"StoredData/img.jpeg";
        loginCredentials();
        DashBoardPage dashBoardPage = lp.goTo();
        AddDeviceToCart addDeviceToCart = dashBoardPage.addDeviceToCart();
        addDeviceToCart.goToHomePage();
       Assert.assertTrue(addDeviceToCart.verifyNavigation());
        addDeviceToCart.alreadyItem();
        addDeviceToCart.addCart("Canon EOS 5D");
        Assert.assertTrue(addDeviceToCart.verifyTheNavigatePage());
        addDeviceToCart.addingProduct("Blue");
        addDeviceToCart.setClickOnTheCartButton();
        Assert.assertTrue(addDeviceToCart.getVerifyText());

    }
}
