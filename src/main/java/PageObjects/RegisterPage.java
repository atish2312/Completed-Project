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

    public void enterRegisterForm(){
        waitForElementClickable(firstName).sendKeys();
        firstName.sendKeys(getRandomName());
        lastName.sendKeys("df");
        email.sendKeys("df");
        telephone.sendKeys("dd");
        getSelect(agree).selectByValue("1");

    }




}
