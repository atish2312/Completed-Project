package PageObjects;

import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    WebDriver driver;
    public DashBoardPage(WebDriver driver){
        this.driver = driver;
    }
    public RegisterPage registerPage(){
        return new RegisterPage(driver);
    }
   public LoginPage loginPage(){
        return new LoginPage(driver);
    }
    public AddDeviceToCart addDeviceToCart(){
        return new AddDeviceToCart(driver);
    }



}
