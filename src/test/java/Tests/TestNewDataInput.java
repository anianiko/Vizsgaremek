package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.Contact;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestNewDataInput extends TestEnvironment {

    @Test
    @Epic("Contact form")
    @Description("User send a message via contact form.")
    @DisplayName("Sending message via Contact form test")
    @Severity(SeverityLevel.CRITICAL)
    public void sendMessageTest(){

        Contact contact = new Contact(driver);

        contact.navigate();
        contact.writeContactMail(Constans.CONTACT_NAME, Constans.CONTACT_EMAIL, Constans.CONTACT_SUBJECT, Constans.CONTACT_MESSAGE);
        makeScreenshot("Filled contact fields");
        contact.pushSubmitButton();

        Assertions.assertFalse(contact.isContactErrorMessage());  //hibaüzenetre vizsgálunk rá. Ha nem volt hibaüzenet, akkor false-t ad.

    }

}
