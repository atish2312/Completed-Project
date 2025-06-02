package PageObjects;

import CommonMethods.AbstractMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractMethods {
     WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id="input-password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @FindBy(css = ".alert-dismissible")
    WebElement errorDisplay;

    @FindBy(xpath = "//h2[text()= 'My Account']")
    WebElement checkPage;

    @FindBy(css = ".alert-dismissible")
    WebElement getErrorDisplay;


    public void enterCredentials(String enterEmail , String enterPassword){
        waitForElementClickable(email).sendKeys(enterEmail);
        waitForElementClickable(password).sendKeys(enterPassword);
        loginButton.click();
    }
    public void checkErrorDisplay(){
        errorDisplay.isDisplayed();
        System.out.println(errorDisplay.getText());
    }
    public void verifyMyAccountPage(){
      waitForElementDisplay(checkPage).isDisplayed();
        System.out.println(checkPage.getText());
    }
    public boolean errorDisplay(){
      return  getErrorDisplay.isDisplayed();


    }


}
