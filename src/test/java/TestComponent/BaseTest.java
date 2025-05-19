package TestComponent;

import PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Properties prop;
    public  LandingPage lp;
    public WebDriver intialize() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resources/GlobalData.Properties");
         prop = new Properties();
        prop.load(file);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        return driver;
    }
    @BeforeMethod
    public LandingPage landingPage() throws IOException {
        driver = intialize();
         lp = new LandingPage(driver,prop);
         return lp;





    }
}
