package blondeSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends BasePage{

    private final String URL = "https://lennertamas.github.io/blondesite/";

    private final By findRegisterTab = By.id("register-form-button");

    private final By findRegisterUsername = By.id("register-username");

    private final By findRegisterPassword = By.id("register-password");

    private final By findRegisterEmail = By.id("register-email");

    private final By findRegisterDescription = By.id("register-description");

    private final By findRegisterButton = By.xpath("//button[@onclick='registerUser()']");

    private final By RegisterAlert = By.id("register-alert");



    //konstruktor
    public Register(WebDriver driver) {
        super(driver);
    }



    public void navigateToRegisterTab(){
        driver.navigate().to(URL);
        driver.findElement(findRegisterTab).click();
    }
/*
    public void pushRegisterTab(){
        driver.findElement(findRegisterTab).click();
    }


 */
    public void writeNewUsername(String username){
        driver.findElement(findRegisterUsername).sendKeys(username);
    }

    public void writeNewPassword(String password){
        driver.findElement(findRegisterPassword).sendKeys(password);
    }

    public void writeNewEmailAddress(String emailAddress){
        driver.findElement(findRegisterEmail).sendKeys(emailAddress);
    }

    public void writeNewDescription(String description){
        driver.findElement(findRegisterDescription).sendKeys(description);
    }

    public void pushRegisterButton(){
        driver.findElement(findRegisterButton).click();
    }


    public void makeNewRegistration(String username, String password, String emailAddress, String description){
        driver.findElement(findRegisterTab).click();   //ezt a sort pushRegisterTab()-bal helyettesíteni?
        writeNewUsername(username);
        writeNewPassword(password);
        writeNewEmailAddress(emailAddress);
        writeNewDescription(description);
        pushRegisterButton();
    }


    public String registerMessageResult(){
        String registerMessage = driver.findElement(RegisterAlert).getText();
        return registerMessage;
    }
}
