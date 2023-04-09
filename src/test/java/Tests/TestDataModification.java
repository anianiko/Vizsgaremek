package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.Profile;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


public class TestDataModification extends TestEnvironment{

    @Test
    @Epic("Modify profile data")
    @Description("User modify profile data on Profile subpage.")
    @Severity(SeverityLevel.NORMAL)
    public void modificationProfileTest(){

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
        profile.writeIntoNameField(NAME);
        profile.writeIntoBioField(BIO);
        profile.writeIntoPhoneField(PHONE);
        profile.clickOnSaveProfileButton();

        Assertions.assertTrue(profile.profileModifySuccessMessage());
    }

}
