package blondeSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AcceptTermsAndConditions extends BasePage{

    private final String URL = "https://lennertamas.github.io/blondesite/";

    private final By findTermsAcceptButton = By.id("terms-and-conditions-button");

    private final By findTermsCloseButton = By.xpath("//*[@onclick='closeModal()']");



    //konstruktor
    public AcceptTermsAndConditions(WebDriver driver) {
        super(driver);
    }


    public void navigate(){
        driver.navigate().to(URL);
    }

    public void clickOnAcceptButton(){
        WebElement AcceptButton = driver.findElement(findTermsAcceptButton);
        AcceptButton.click();
    }

    public void clickOnCloseButton(){
        WebElement CloseButton = driver.findElement(findTermsCloseButton);
        CloseButton.click();
    }

    public boolean contractResult(){
        boolean termsAndConditionsVisible = driver.findElement(By.id("overlay")).isDisplayed();
        return termsAndConditionsVisible;
    }

}
