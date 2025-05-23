package CommonMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public Select getSelect(WebElement element){
        return  new Select(element);
    }
    public  WebElement waitForElementClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
