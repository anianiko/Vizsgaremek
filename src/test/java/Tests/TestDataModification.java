package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.Profile;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


public class TestDataModification extends TestEnvironment{

    @Test
    @Epic("Modify profile data")
    @Description("User modify profile data on Profile subpage.")
    @DisplayName("Modify profile data test")
    @Severity(SeverityLevel.NORMAL)
    public void modificationProfileTest(){

        loginWithNewRegistration(Constans.USERNAME, Constans.PASSWORD, Constans.EMAIL, Constans.DESCRIPTION);

        Profile profile = new Profile(driver);
        profile.clickOnProfileLink();
        profile.writeIntoNameField(Constans.PROFILE_NAME);
        profile.writeIntoBioField(Constans.PROFILE_BIO);
        profile.writeIntoPhoneField(Constans.PROFILE_PHONE);
        profile.clickOnSaveProfileButton();

        Assertions.assertTrue(profile.profileModifySuccessMessage());
    }

}
