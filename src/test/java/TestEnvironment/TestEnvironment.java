package TestEnvironment;

import blondeSite.Login;
import blondeSite.Register;
import blondeSite.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class TestEnvironment {

    public WebDriver driver;

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

    @AfterEach
    public void dispose() {
        makeScreenshot("End of the test.");
        driver.quit();
    }


    public void loginWithNewRegistration(String username, String password, String email, String description){
        Register register = new Register(driver);
        TermsAndConditions acceptTerms = new TermsAndConditions(driver);

        acceptTerms.navigate();
        acceptTerms.clickOnAcceptButton();

        register.navigateToRegisterTab();
        register.writeNewUsername(username);
        register.writeNewPassword(password);
        register.writeNewEmailAddress(email);
        register.writeNewDescription(description);
        register.pushRegisterButton();

        Login login = new Login(driver);
        login.navigateToLoginTab();
        login.writeLoginUsername(username);
        login.writeLoginPassword(password);
        login.pushLoginButton();
    }

    public void makeScreenshot(String title){
        Allure.addAttachment(title, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
