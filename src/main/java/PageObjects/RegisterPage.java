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

    public String getFirstName(){
        String name = getRandomName();
        System.out.println(name);
        return name;
    }
    public String getLastName(){
        String lastName = getRandomName();
        System.out.println(lastName);
        return lastName;
    }
    public long getPhoneNumber(){
        long phoneNumber = generateNumber();
        System.out.println(phoneNumber);
        return phoneNumber;

    }
    public String getEmails(){
        String email = getEmail();
        System.out.println(email);
        return email;
    }

    public void enterRegisterForm(){
        waitForElementClickable(firstName).sendKeys(getFirstName());
       waitForElementClickable(lastName).sendKeys(getLastName());
        waitForElementClickable(email).sendKeys(getEmails());
       waitForElementClickable(telephone).sendKeys(String.valueOf(getPhoneNumber()));
       waitForElementClickable(password).sendKeys(getFirstName());
       waitForElementClickable(confirmPassword).sendKeys(getFirstName());
       waitForElementClickable(agree).click();

    }




}
