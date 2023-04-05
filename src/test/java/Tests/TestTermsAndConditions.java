package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.Register;
import blondeSite.TermsAndConditions;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestTermsAndConditions extends TestEnvironment {


    @Test
    @Epic("Terms & Conditions")
    @Description("Visitor open the website for the first time and Terms&Conditions is displayed on the screen.")
    @Severity(SeverityLevel.CRITICAL)
    public void isDisplayedTermsAndConditionsTest(){
        TermsAndConditions termsAndConditions = new TermsAndConditions(driver);
        termsAndConditions.navigate();
        boolean actualResult = termsAndConditions.contractResult();

        Assertions.assertTrue(actualResult);
    }

    @Test
    @Epic("Terms & Conditions")
    @Description("Visitor open the website for the first time, reject the Terms&Conditions, so visitor cannot register on the website.")
    @Severity(SeverityLevel.CRITICAL)
    public void registrationWithRejectedTermsAndConditionsTest(){
        String TEST_USERNAME ="Dog";
        String TEST_PASSWORD ="Hello123";
        String TEST_EMAIL ="dog@cool.com";
        String TEST_DESCRIPTION ="tester";

        TermsAndConditions termsAndConditions = new TermsAndConditions(driver);
        termsAndConditions.navigate();
        termsAndConditions.clickOnCloseTermsButton();

        Register register = new Register(driver);
        register.makeNewRegistration(TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_DESCRIPTION);

        String actualResult = register.registerMessageResult();
        String expectedResult = "User cannot register without accepting the Terms And Conditions!";
        //String expectedResult = "User registered!";
        Assertions.assertEquals(expectedResult, actualResult);

        /*
        Login login = new Login(driver);
        login.pushLoginTab();
        login.loginWithDatas(TEST_USERNAME, TEST_PASSWORD);
        String expectedResult2 = "Username or Password\nis not correct!";
        String actualResult2 = login.failedLoginMessageResult();

        Assertions.assertEquals(expectedResult2, actualResult2);

         */
    }

}
