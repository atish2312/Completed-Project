package Tests;

import PageObjects.AddDeviceToCart;
import PageObjects.DashBoardPage;
import TestComponent.BaseTest;
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
        addDeviceToCart.verifyNavigation();
        addDeviceToCart.alreadyItem();
        addDeviceToCart.addCart();
        addDeviceToCart.setAddToCartButton("Small","Checkbox 1","Hello Atish Kumar","Yellow","Atish this is text area");
    }
}
