package PageObjects;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LandingPage {
    WebDriver driver;
    Properties prop;

    public LandingPage(WebDriver driver, Properties prop){
        this.driver = driver;
        this.prop = prop;

    }
    public DashBoardPage goTo(){
        driver.get(prop.getProperty("url"));
        return new  DashBoardPage(driver);
    }
}
