package blondeSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage{

    private final String URL = "https://lennertamas.github.io/blondesite/";

    private final By findLoginTab = By.id("login-form-button");

    private final By findLoginUsername = By.id("email");

    private final By findLoginPassword = By.id("password");

    private final By findLoginButton = By.xpath("//button[@onclick='myFunction()']");

    private final By failedLoginAlert = By.id("alert");

    private final By findLogoutButton = By.xpath("//a[@onclick='logout()']");



    //kontruktor
    public Login(WebDriver driver) {
        super(driver);
    }


    public void navigateToLoginTab(){
        driver.navigate().to(URL);
        driver.findElement(findLoginTab).click();
    }
    public void pushLoginTab(){
        driver.findElement(findLoginTab).click();
    }

    public void writeLoginUsername(String username){
        driver.findElement(findLoginUsername).sendKeys(username);
    }

    public void writeLoginPassword(String password){
        driver.findElement(findLoginPassword).sendKeys(password);
    }

    public void pushLoginButton(){
        driver.findElement(findLoginButton).click();
    }

    public String failedLoginMessageResult(){
        String loginMessage = driver.findElement(failedLoginAlert).getText();
        return loginMessage;
    }

    public String findLogoutButton(){
        String logoutButtonLabel = driver.findElement(findLogoutButton).getText();
        return logoutButtonLabel;
    }

    public String findLoginButton(){
        String loginButtonLabel = driver.findElement(findLoginButton).getText();
        return loginButtonLabel;
    }

    public void pushLogoutButton(){
        driver.findElement(findLogoutButton).click();
    }


    public void loginWithData(String username, String password){
        writeLoginUsername(username);
        writeLoginPassword(password);
        pushLoginButton();
    }


}
