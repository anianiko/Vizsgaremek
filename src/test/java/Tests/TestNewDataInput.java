package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.Contact;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestNewDataInput extends TestEnvironment {

    @Test
    @Epic("User login/logout")
    @Description("User accept Terms&Conditions and log in with registered username and password.")
    @Severity(SeverityLevel.NORMAL)
    public void sendMessageTest(){

        String CONTACT_NAME = "Aniko";
        String CONTACT_EMAIL = "aniko@cool.com";
        String CONTACT_SUBJECT = "say hello letter";
        String CONTACT_MESSAGE = "Hello, the website is really great. A.";

        Contact contact = new Contact(driver);

        contact.navigate();
        contact.writeContactMail(CONTACT_NAME, CONTACT_EMAIL, CONTACT_SUBJECT, CONTACT_MESSAGE);

        Assertions.assertFalse(contact.isContactErrorMessage());  //hibaüzenetre vizsgálunk rá. Ha nem volt hibaüzenet, akkor false-t ad.

    }

}
