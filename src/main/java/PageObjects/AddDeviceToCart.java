package PageObjects;

import CommonMethods.AbstractMethods;
import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class AddDeviceToCart extends AbstractMethods {
    WebDriver driver;
    public AddDeviceToCart(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
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

    public void goToHomePage(){
        waitForElementClickable(homeButton).click();
    }
    public boolean verifyNavigation(){
       return waitForElementDisplay(textStore).isDisplayed();
    }
    public void alreadyItem(){
        if(getAlreadyItem.getText().contains("$0.00")){
            return;
        }
        else{
                waitForElementClickable(cartButton).click();
                waitForElementClickable(removeTheProduct).click();
        }

    }

    public void addCart(){
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='caption']/h4"));
        String name = "Apple Cinema 30";

        for(int i = 0 ; i<names.size();i++) {

            String getName = names.get(i).getText();
            String[] nameFormatted = getName.split("\"");
            String formattedName = nameFormatted[0].trim();
            System.out.println(formattedName);
         if(name.equalsIgnoreCase(formattedName)){
                driver.findElements(By.xpath("//div[@class='button-group']")).get(i).click();
                break;
            }
        }

    }
    @FindBy(xpath = "//div[@class='form-group']/button")
    WebElement getAddToCartButton;

    public void setAddToCartButton(String sizeDevice , String checkbox , String src){
       waitForElementClick(By.xpath("//div[@id='input-option218']/div/label[contains(normalize-space(),'"+sizeDevice+"')]")).click();
        waitForElementClick(By.xpath("//div[@id='input-option223']/div/label[contains(normalize-space(),'"+checkbox+"')]")).click();
        waitForElementClick(By.xpath("//input[@id='input-option208']")).sendKeys("For Working");
        waitForElementClick(By.id("button-upload222")).sendKeys(src);
        waitForElementClick(By.xpath("//input[@id='input-option222']")).sendKeys(src);
        waitForElementClickable(getAddToCartButton).click();
    }

}
