package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.AcceptTermsAndConditions;
import blondeSite.Register;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class TestRegistration {


    WebDriver driver;


    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");   //visszakapcsolni push előtt
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    String NEW_USERNAME = "dunaianiko";
    String NEW_PASSWORD = "mammamia123";
    String NEW_EMAIL = "cool@code.com";
    String NEW_DESCRIPTION = "Tester";





    @Test
    @Epic("User registration")
    //@Story("User registration")
    @Description("A new user accept Terms&Conditions and register on the site.")
    @Severity(SeverityLevel.NORMAL)
    public void registerTest() {
        Register register = new Register(driver);
        AcceptTermsAndConditions acceptTerms = new AcceptTermsAndConditions(driver);

        acceptTerms.navigate();
        acceptTerms.clickOnAcceptButton();

        register.navigateToRegisterTab();
        register.writeNewUsername(NEW_USERNAME);
        register.writeNewPassword(NEW_PASSWORD);
        register.writeNewEmailAddress(NEW_EMAIL);
        register.writeNewDescription(NEW_DESCRIPTION);
        register.pushRegisterButton();

        String expectedResult ="User registered!";
        String actualResult = register.registerMessageResult();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    @Epic("Make screenshot for report")
   // @Story("Make screenshot for report")
    @Description("Make screenshot after each test")
    @Severity(SeverityLevel.CRITICAL)
    public void makeScreenshot(){
        Allure.addAttachment("Screenshot of tested page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }


}
