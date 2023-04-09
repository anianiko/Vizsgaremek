package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.Login;
import blondeSite.Profile;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDeleteData extends TestEnvironment {

    @Test
    @Epic("Delete account")
    @Description("User delete account on Profile subpage.")
    @Severity(SeverityLevel.NORMAL)
    public void deleteProfileTest() {

        String USERNAME = "Anna";
        String PASSWORD = "mammamia123";
        String EMAIL = "cool@code.com";
        String DESCRIPTION = "Tester";

        String NAME = "Anna Smith";
        String BIO = "bio";
        String PHONE = "0051 1234 5678";

        //TestEnvironmentbe kiemelt reg+login metódus
        loginWithNewRegistration(USERNAME, PASSWORD, EMAIL, DESCRIPTION);

        Profile profile = new Profile(driver);
        profile.clickOnProfileLink();
        profile.clickOnDeleteAccountButton();
        makeScreenshot("\"I am Sure! Delete my account\" button is displayed");
        profile.clickOnDeleteAccountSureButton();


        Login login = new Login(driver);
        login.loginWithData(USERNAME, PASSWORD);

        String expectedResult = "Username or Password\n" + "is not correct!";
        String actualResult = login.failedLoginMessageResult();

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
