package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.AcceptTermsAndConditions;
import blondeSite.Login;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLoginLogout extends TestEnvironment{


   // WebDriver driver;

  /*  public TestLogin(WebDriver driver) {
        super(driver);
    }


   */
/*
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
        //options.addArguments("--headless");   //visszakapcsolni push előtt
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }



 */
    String REGISTERED_USERNAME = "lovasia";
    String REGISTERED_PASSWORD = "kispal123";


    @Test
    @Epic("User login/logout")
    @Description("User accept Terms&Conditions and log in with registered username and password.")
    @Severity(SeverityLevel.NORMAL)
    public void loginTest(){
        Login login = new Login(driver);
        AcceptTermsAndConditions acceptTerms = new AcceptTermsAndConditions(driver);

        acceptTerms.navigate();
        acceptTerms.clickOnAcceptButton();

        login.navigateToLoginTab();
        login.writeLoginUsername(REGISTERED_USERNAME);
        login.writeLoginPassword(REGISTERED_PASSWORD);
        login.pushLoginButton();

        String expectedResult = "Logout";
        String actualResult = login.findLogoutButton();
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    @Epic("User login/logout")
    @Description("User accept Terms&Conditions, log in with registered username/password and log out from the site.")
    @Severity(SeverityLevel.NORMAL)
    public void logoutTest() throws InterruptedException {
        Login login = new Login(driver);
        AcceptTermsAndConditions acceptTerms = new AcceptTermsAndConditions(driver);

        acceptTerms.navigate();
        acceptTerms.clickOnAcceptButton();

        login.navigateToLoginTab();
        login.writeLoginUsername(REGISTERED_USERNAME);
        login.writeLoginPassword(REGISTERED_PASSWORD);
        login.pushLoginButton();
        Thread.sleep(2000);
        login.pushLogoutButton();

        String expectedResult = "Login";
        String actualResult = login.findLoginButton();
        Assertions.assertEquals(expectedResult, actualResult);

    }

    /*
    @AfterEach

    public void makeScreenshot(){
        Allure.addAttachment("Screenshot of tested page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }


     */
}
