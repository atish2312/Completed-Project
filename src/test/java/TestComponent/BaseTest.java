package TestComponent;

import CommonMethods.AbstractMethods;
import PageObjects.DashBoardPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.ExtentReportNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;


public class BaseTest {
    public WebDriver driver;
    Properties prop;
    public LandingPage lp;
    public static ExtentTest test;
    ExtentReportNG reportNG = new ExtentReportNG();
    ExtentReports reports = reportNG.extentReports();

    public WebDriver intialize() throws IOException {

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Resources/GlobalData.Properties");
        prop = new Properties();
        prop.load(file);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public LandingPage landingPage() throws IOException {
        driver = intialize();
        lp = new LandingPage(driver, prop);

      System.out.println(System.getProperty("user.dir")+"\\Screenshots");
        return lp;
    }

    @AfterMethod
    public void tearDown() {
       driver.quit();
    }

    public String takeScreenShot(String testCaseName, WebDriver driver) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshot = System.getProperty("user.dir") + "/Screenshots/" + testCaseName + ".png";
        FileUtils.copyFile(src, new File(screenshot));
        return "../Screenshots/" + testCaseName + ".png";
    }

    public void loginCredentials() {
        DashBoardPage dashBoardPage = lp.goTo();
        LoginPage loginPage = dashBoardPage.loginPage();
        String email = "rjt@yopmail.com";
        String password = "Atish123!";
        loginPage.enterCredentials(userEmail,userPassword);
        loginPage.verifyMyAccountPage();
    }

    public static String userFirstName;
    public static String userLastName;
    public static String userEmail;
    public static String userPhoneNumber;
    public static String userPassword;

    @BeforeSuite
    public  void deleteTheFolderandrandomUserCredenials(){
        AbstractMethods op = new AbstractMethods(driver);
        op.deleteFile(System.getProperty("user.dir")+"\\Screenshots");
            userFirstName = UUID.randomUUID().toString().substring(0, 5);
            userLastName = UUID.randomUUID().toString().substring(0, 7);
            userEmail = UUID.randomUUID().toString().substring(0, 7) + "@yopmail.com";
            userPhoneNumber = UUID.randomUUID().toString().substring(0, 9);
            userPassword = UUID.randomUUID().toString().substring(0, 10);
            System.out.println(userEmail + "----------");
        }
    }




