package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.Login;
import blondeSite.Profile;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestDeleteData extends TestEnvironment {

    @Test
    @Epic("Delete account")
    @Description("User delete account on Profile subpage.")
    @DisplayName("TC06 Delete account test")
    @Severity(SeverityLevel.NORMAL)
    public void deleteProfileTest() {

        loginWithNewRegistration(Constans.USERNAME, Constans.PASSWORD, Constans.EMAIL, Constans.DESCRIPTION);

        Profile profile = new Profile(driver);
        profile.clickOnProfileLink();
        profile.clickOnDeleteAccountButton();
        makeScreenshot("\"I am Sure! Delete my account\" button is displayed");
        profile.clickOnDeleteAccountSureButton();


        Login login = new Login(driver);
        login.loginWithData(Constans.USERNAME, Constans.PASSWORD);

        String expectedResult = "Username or Password\n" + "is not correct!";
        String actualResult = login.failedLoginMessageResult();

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
