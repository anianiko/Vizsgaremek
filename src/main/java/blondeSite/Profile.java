package blondeSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Profile extends BasePage{

    private final String URL = "https://lennertamas.github.io/blondesite/";

    private final By findProfileLink = By.xpath("//a[@href='/blondesite/profile.html']");

    private final By findProfileName = By.id("name");

    private final By findProfileBio = By.id("bio");

    private final By findProfilePhone = By.id("phone-number");

    private final By findSaveProfileButton = By.xpath("//button[@onclick='editUser()']");

    private final By findDeleteAccountButton = By.xpath("//button[@onclick='showRealDeleteAccBtn()']");

    private final By findDeleteAccountIAmSureButton = By.xpath("//button[@onclick='deleteAccount()']");

    //konstruktor
    public Profile(WebDriver driver) {
        super(driver);
    }


    public void navigate(){
        driver.navigate().to(URL);
    }

    public void clickOnProfileLink() {
        driver.findElement(findProfileLink).click();
    }

    public void clickOnSaveProfileButton() {
        driver.findElement(findSaveProfileButton).click();
    }

    public void clickOnDeleteAccountButton() {
        driver.findElement(findDeleteAccountButton).click();
    }

    public void clickOnDeleteAccountSureButton() {
        driver.findElement(findDeleteAccountIAmSureButton);
    }

    public void writeIntoNameField(String name) {
        driver.findElement(findProfileName).sendKeys(name);
    }

    public void writeIntoBioField(String bio) {
        driver.findElement(findProfileBio).sendKeys(bio);
    }

    public void writeIntoPhoneField(String phone) {
        driver.findElement(findProfilePhone).sendKeys(phone);
    }


    public void modifyMessageResult(){
        //TODO ide megírni egy metódust, ami kikeresi az adatmódosítás sikeres létrejöttének visszaigazolását
        //nem működik az oldalon az adatmentés
    }

}
