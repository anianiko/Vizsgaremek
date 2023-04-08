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

    private final By findContactErrorMessage = By.xpath("//p[text()='Form not found.']");  //beküldés utáni hibaüzenet

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

    public void writeContactEmailAddress(String mail){
        driver.findElement(findContactEmailAddress).sendKeys(mail);
    }

    public void writeContactSubject(String subject){
        driver.findElement(findContactSubject).sendKeys(subject);
    }

    public void writeContactMessage(String message){
        driver.findElement(findContactMessage).sendKeys(message);
    }

    //hibaüzenetre keresünk rá
    public boolean isContactErrorMessage(){
        try {
            driver.findElement(findContactErrorMessage);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public void writeContactMail(String name, String mail, String subject, String message){
        writeContactName(name);
        writeContactEmailAddress(mail);
        writeContactSubject(subject);
        writeContactMessage(message);
    }
    public void pushSubmitButton(){
        driver.findElement(findContactSubmitButton).click();
    }

}
