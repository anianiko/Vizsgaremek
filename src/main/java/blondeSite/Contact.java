package blondeSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contact extends BasePage{

    private final String URL = "https://lennertamas.github.io/blondesite/contact/";

    private final By findContactYourName = By.name("name");

    private final By findContactEmailAddress = By.name("mail");

    private final By findContactSubject = By.name("title");

    private final By findContactMessage = By.name("message");

    private final By findContactSubmitButton = By.xpath("//*[@value='Submit']");

    //konstruktor
    public Contact(WebDriver driver) {
        super(driver);
    }



    public void navigate(){
        driver.navigate().to(URL);
    }

    public void writeContactName(String name){
        driver.findElement(findContactYourName).sendKeys(name);
    }

    public void writeContactEmail(String mail){
        driver.findElement(findContactEmailAddress).sendKeys(mail);
    }

    public void writeContactSubject(String subject){
        driver.findElement(findContactSubject).sendKeys(subject);
    }

    public void writeContactMessage(String message){
        driver.findElement(findContactMessage).sendKeys(message);
    }

    public void pushSubmitButton(){
        driver.findElement(findContactSubmitButton).click();
    }

}
