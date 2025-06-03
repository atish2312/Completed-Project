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

    public void addCart() {
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='caption']/h4"));
        String name = "Apple Cinema 30";

        for (int i = 0; i < names.size(); i++) {

            String getName = names.get(i).getText();
            String[] nameFormatted = getName.split("\"");
            String formattedName = nameFormatted[0].trim();
            System.out.println(formattedName);
            if (name.equalsIgnoreCase(formattedName)) {
                driver.findElements(By.xpath("//div[@class='button-group']/button[1]")).get(i).click();
                break;
            }
        }

    }

    @FindBy(xpath = "//div[@class='form-group']/button")
    WebElement getAddToCartButton;

    @FindBy(id = "input-option217")
    WebElement select;

    @FindBy(id = "input-option209")
    WebElement getTextArea;

    public void setAddToCartButton(String sizeDevice, String checkbox , String text ,String colorOfProduct,String textArea) throws InterruptedException, AWTException {
        WebElement intext =  waitForElementClick(By.xpath("//input[@id='input-option208']"));
        waitForElementClick(By.xpath("//div[@id='input-option218']/div/label[contains(normalize-space(),'" + sizeDevice + "')]")).click();
        waitForElementClick(By.xpath("//div[@id='input-option223']/div/label[contains(normalize-space(),'" + checkbox + "')]")).click();
        getActions().click(intext).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys(text).build().perform();
        waitForElementClick(By.id("input-option217")).click();
        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@id='input-option217']/option"));
        for(int i = 1 ; i< allOptions.size();i++){
            driver.findElement(By.xpath("//option[contains(text(),'"+colorOfProduct+"')]")).click();
            break;
        }
        waitForElementClickable(getTextArea).sendKeys(textArea);
        driver.findElement(By.id("button-upload222")).click();
        Robot robot = new Robot();
        robot.delay(2000);
        StringSelection selection = new StringSelection("C:\\Users\\appde\\OneDrive\\Desktop\\OpenCart\\opencart\\StoredData\\2.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(200);
        getAlert().accept();
        waitForElementDisplay(getAddToCartButton).click();
    }
}