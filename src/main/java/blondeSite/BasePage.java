package blondeSite;

import org.openqa.selenium.WebDriver;

public class BasePage {

    //private final String URL = "https://lennertamas.github.io/blondesite/";
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    WebDriver driver;


}
