package PageObjects;

import CommonMethods.AbstractMethods;
import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

public class AddDeviceToCart extends AbstractMethods {
    WebDriver driver;

    public AddDeviceToCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".fa-home")
    WebElement homeButton;

    @FindBy(xpath = "//a[text()='Your Store']")
    WebElement textStore;

    @FindBy(xpath = "//div[@class='caption']/h4")
    WebElement devicesNames;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    WebElement addToCartButton;

    @FindBy(id = "cart-total")
    WebElement getAlreadyItem;

    @FindBy(xpath = "//div[@id=\"cart\"]")
    WebElement cartButton;

    @FindBy(css = ".fa-times")
    WebElement removeTheProduct;

    public void goToHomePage() {
        waitForElementClickable(homeButton).click();
    }

    public boolean verifyNavigation() {
        return waitForElementDisplay(textStore).isDisplayed();
    }

    public void alreadyItem() {
        if (getAlreadyItem.getText().contains("$0.00")) {
            return;
        } else {
            waitForElementClickable(cartButton).click();
            waitForElementClickable(removeTheProduct).click();
        }

    }

    public void addCart(String name) {
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='caption']/h4"));
        for (int i = 0; i < names.size(); i++) {

            String getName = names.get(i).getText();
            String[] nameFormatted = getName.split("\"");
            String formattedName = nameFormatted[0].trim();
            System.out.println(formattedName);
            if (name.equalsIgnoreCase(formattedName)) {
                driver.findElements(By.xpath("//div[@class='image']")).get(i).click();
                break;
            }
        }

    }
    @FindBy(css = ".alert-success")
    WebElement checkItem;

    public boolean checkItemAdded(){
        return  checkItem.isDisplayed();
    }

    @FindBy(xpath = "//div[@class='form-group']/button")
    WebElement getAddToCartButton;

    @FindBy(id = "input-option217")
    WebElement select;

    @FindBy(id = "input-option209")
    WebElement getTextArea;

    @FindBy(xpath = "//h1[normalize-space()='iPhone']")
    WebElement verifyNavigation;

    public boolean verifyTheNavigatePage(){
       return waitForElementDisplay(verifyNavigation).isDisplayed();
    }

    @FindBy(id = "input-option226")
    WebElement displayAvailable;


//    public void addingProduct(String color) {
//
//        waitForElementClickable(displayAvailable).click();
//        List<WebElement> allOption = driver.findElements(By.xpath("//select[@id='input-option226']/option"));
//        for (int i = 0; i < allOption.size(); i++) {
//            if (allOption.get(i).getText().equalsIgnoreCase("Blue")) {
//                allOption.get(i).click();
//                break;
//            }
//        }
//    }
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement clickOnTheCartButton;

    public void setClickOnTheCartButton(){
        waitForElementClickable(clickOnTheCartButton).click();
    }
    @FindBy(css = ".alert-success.alert-success")
    WebElement verifySuccess;

    public boolean getVerifyText(){
       return waitForElementDisplay(verifySuccess).isDisplayed();
    }




}