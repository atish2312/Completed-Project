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
    WebElement telephone;

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


    public void enterRegisterForm(String enterFirstName , String enterLastName , String enterEmail , String telephoneNumber, String enterPassword, String enterConfirmPassword){
        waitForElementClickable(clickOnTheRegisterPage).click();
        waitForElementClickable(firstName).sendKeys(enterFirstName);
       waitForElementClickable(lastName).sendKeys(enterLastName);
        waitForElementClickable(email).sendKeys(enterEmail);
       waitForElementClickable(telephone).sendKeys(telephoneNumber);
       waitForElementClickable(password).sendKeys(enterPassword);
       waitForElementClickable(confirmPassword).sendKeys(enterConfirmPassword);
       waitForElementClickable(agree).click();
       waitForElementClickable(continueButton).click();
    }
    public boolean isDisplay(){
        System.out.println(errorEmail.getText());
      return   errorEmail.isDisplayed();
    }
}
