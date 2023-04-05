package Tests;

import TestEnvironment.TestEnvironment;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class TestDataModification extends TestEnvironment{
/*
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
        //options.addArguments("--headless");   //visszakapcsolni push előtt
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


 */

    @Test
    @Epic("User modify profile datas")
    //@Story(".................")
    @Description(".......................")
    //@DisplayName(".................")
    @Severity(SeverityLevel.NORMAL)
    public void ModificationProfileTest(){

        //TODO

    }

/*
    @AfterEach
    @Epic("Make screenshot for report")
    // @Story("Make screenshot for report")
    @Description("Make screenshot after each test")
    @Severity(SeverityLevel.CRITICAL)
    public void makeScreenshot(){
        Allure.addAttachment("Screenshot of tested page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

 */
}
