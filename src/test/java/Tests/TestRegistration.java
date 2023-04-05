package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.TermsAndConditions;
import blondeSite.Register;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestRegistration extends TestEnvironment{

    String NEW_USERNAME = "dunaianiko";
    String NEW_PASSWORD = "mammamia123";
    String NEW_EMAIL = "cool@code.com";
    String NEW_DESCRIPTION = "Tester";


    @Test
    @Epic("User registration")
    @Description("A new user accept Terms&Conditions and register on the site.")
    @Severity(SeverityLevel.NORMAL)
    public void registerTest() {
        Register register = new Register(driver);
        TermsAndConditions acceptTerms = new TermsAndConditions(driver);

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
}
