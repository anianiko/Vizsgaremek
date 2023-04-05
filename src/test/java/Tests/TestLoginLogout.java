package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.TermsAndConditions;
import blondeSite.Login;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLoginLogout extends TestEnvironment{

    String REGISTERED_USERNAME = "lovasia";
    String REGISTERED_PASSWORD = "kispal123";


    @Test
    @Epic("User login/logout")
    @Description("User accept Terms&Conditions and log in with registered username and password.")
    @Severity(SeverityLevel.NORMAL)
    public void loginTest(){
        Login login = new Login(driver);
        TermsAndConditions acceptTerms = new TermsAndConditions(driver);

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
    public void logoutTest() {
        Login login = new Login(driver);
        TermsAndConditions acceptTerms = new TermsAndConditions(driver);

        acceptTerms.navigate();
        acceptTerms.clickOnAcceptButton();

        login.navigateToLoginTab();
        login.writeLoginUsername(REGISTERED_USERNAME);
        login.writeLoginPassword(REGISTERED_PASSWORD);
        login.pushLoginButton();
        login.pushLogoutButton();

        String expectedResult = "Login";
        String actualResult = login.findLoginButton();
        Assertions.assertEquals(expectedResult, actualResult);
    }


}
