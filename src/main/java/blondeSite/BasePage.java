package blondeSite;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    WebDriver driver;


    //görgetés a WebElementhez
    public void scrollToWebElement(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(300);
    }



}
