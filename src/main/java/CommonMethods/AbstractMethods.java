package CommonMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class AbstractMethods  {
    WebDriver driver;
    WebDriverWait wait;
    public AbstractMethods(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public Select getSelect(WebElement element){
        return  new Select(element);
    }
    public  WebElement waitForElementClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement waitForElementDisplay(WebElement element){
        return  wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitForElementClick(By element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public Actions getActions(){
        return new Actions(driver);
    }
    public Alert getAlert(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }

}
