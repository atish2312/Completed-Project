package PageObjects;

import CommonMethods.AbstractMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AbstractMethods {

    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement clickOnTheRegisterPage;
    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(name = "telephone")
    WebElement getTelephone;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @FindBy(name = "agree")
    WebElement agree;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;

    @FindBy(xpath = "//p[contains(text(),'Congratulations')]")
    WebElement congratulations;

    @FindBy(xpath = "//div[contains(text(),'E-Mail Address is already registered')]")
    WebElement errorEmail;


    public String gettext(){
     String success =    congratulations.getText();
      System.out.println(success);
      return success;
    }
    @FindBy(xpath = "//h2[text()='Returning Customer']")
    WebElement getWaitPageLoad;
    @FindBy(xpath = "//div[@class='pull-right']")
    WebElement waitPageLoad;

    public void enterRegisterForm(String getFirstName, String getLastName, String getUserEmail, String getPhoneNumber , String UserPassword){
        waitForElementDisplay(getWaitPageLoad);
        waitForElementClickable(clickOnTheRegisterPage).click();
        waitForElementDisplay(waitPageLoad);
        waitForElementClickable(firstName).sendKeys(getFirstName);
       waitForElementClickable(lastName).sendKeys(getLastName);
        waitForElementClickable(email).sendKeys(getUserEmail);
       waitForElementClickable(getTelephone).sendKeys(getPhoneNumber);
       waitForElementClickable(password).sendKeys(UserPassword);
       waitForElementClickable(confirmPassword).sendKeys(UserPassword);
       waitForElementClickable(agree).click();
       waitForElementClickable(continueButton).click();
    }
    public boolean isDisplay(){
        System.out.println(errorEmail.getText());
      return waitForElementDisplay(errorEmail).isDisplayed();
    }
}
