package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.TermsAndConditions;
import blondeSite.Login;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestLoginLogout extends TestEnvironment{

    @Test
    @Epic("Login/logout")
    @Description("User accept Terms&Conditions and log in with registered username and password.")
    @DisplayName("Login with master username & password after acceptance of the Terms&Conditions test")
    @Severity(SeverityLevel.NORMAL)
    public void loginTest(){
        Login login = new Login(driver);
        TermsAndConditions acceptTerms = new TermsAndConditions(driver);

        acceptTerms.navigate();
        acceptTerms.clickOnAcceptButton();

        login.navigateToLoginTab();
        login.writeLoginUsername(Constans.REGISTERED_USERNAME);
        login.writeLoginPassword(Constans.REGISTERED_PASSWORD);
        login.pushLoginButton();

        String expectedResult = "Logout";
        String actualResult = login.findLogoutButton();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Epic("Login/logout")
    @Description("User accept Terms&Conditions, log in with registered username/password and log out from the site.")
    @DisplayName("Accepting Terms&Conditions, login and logout test")
    @Severity(SeverityLevel.NORMAL)
    public void logoutTest() {
        Login login = new Login(driver);
        TermsAndConditions acceptTerms = new TermsAndConditions(driver);

        acceptTerms.navigate();
        acceptTerms.clickOnAcceptButton();

        login.navigateToLoginTab();
        login.writeLoginUsername(Constans.REGISTERED_USERNAME);
        login.writeLoginPassword(Constans.REGISTERED_PASSWORD);
        login.pushLoginButton();
        login.pushLogoutButton();

        String expectedResult = "Login";
        String actualResult = login.findLoginButton();
        Assertions.assertEquals(expectedResult, actualResult);
    }


}
