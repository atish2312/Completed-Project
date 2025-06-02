package Tests;

import PageObjects.AddDeviceToCart;
import PageObjects.DashBoardPage;
import TestComponent.BaseTest;
import org.testng.annotations.Test;

public class ProductAddTest extends BaseTest {

    @Test
    public void validProduct(){
        String image = System.getProperty("user.dir")+"/Screenshots/validProduct.png";
        loginCredentials();
        DashBoardPage dashBoardPage = lp.goTo();
        AddDeviceToCart addDeviceToCart = dashBoardPage.addDeviceToCart();
        addDeviceToCart.goToHomePage();
        addDeviceToCart.verifyNavigation();
        addDeviceToCart.alreadyItem();
        addDeviceToCart.addCart();
        addDeviceToCart.setAddToCartButton("Small","Checkbox 1",image);


    }
}
