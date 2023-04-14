package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.TermsAndConditions;
import blondeSite.Register;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestRegistration extends TestEnvironment{

    @Test
    @Epic("Registration")
    @Description("A new user accept Terms&Conditions and register on the site.")
    @DisplayName("Registration test")
    @Severity(SeverityLevel.NORMAL)
    public void registerTest() {

        Register register = new Register(driver);
        TermsAndConditions acceptTerms = new TermsAndConditions(driver);

        acceptTerms.navigate();
        acceptTerms.clickOnAcceptButton();

        register.navigateToRegisterTab();
        register.writeNewUsername(Constans.USERNAME);
        register.writeNewPassword(Constans.PASSWORD);
        register.writeNewEmailAddress(Constans.EMAIL);
        register.writeNewDescription(Constans.DESCRIPTION);
        register.pushRegisterButton();

        String expectedResult ="User registered!";
        String actualResult = register.registerMessageResult();
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
