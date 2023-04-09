package blondeSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Profile extends BasePage{

    private final String URL = "https://lennertamas.github.io/blondesite/";

    private final By findProfileLink = By.xpath("//a[@href='/blondesite/profile.html']");

    private final By findProfileName = By.id("name");

    private final By findProfileBio = By.id("bio");

    private final By findProfilePhone = By.id("phone-number");

    private final By findSaveProfileButton = By.xpath("//button[@onclick='editUser()']");

    private final By findDeleteAccountButton = By.xpath("//button[@onclick='showRealDeleteAccBtn()']");

    private final By findDeleteAccountIAmSureButton = By.xpath("//button[@onclick='deleteAccount()']");

    private final By findEditAlert = By.id("edit-alert");

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
        driver.findElement(findDeleteAccountIAmSureButton).click();
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


    //edit-alert csak sikeres módosítás után jelenik meg (style), így csekkolható getAttribute-tal is
    public boolean profileModifySuccessMessage(){
        WebElement editAlert = driver.findElement(findEditAlert);
        String valueOfEditAlertStyleAttribute = editAlert.getAttribute("style");
        String expectedValue = "display: block;";
        if (valueOfEditAlertStyleAttribute.equals(expectedValue))
            return true;
        else
            return false;
    }

    //másik megoldás egy olyan metódust, ami kikeresi az adatmódosítás sikeres létrejöttének visszaigazolását
/*
    public String profileModifyAlertMessage(){
        String profileModifyAlertMessage = driver.findElement(findEditAlert).getText();
        return profileModifyAlertMessage;
    }

 */


}


