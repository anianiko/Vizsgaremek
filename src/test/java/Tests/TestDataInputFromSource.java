package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.Login;
import blondeSite.Register;
import blondeSite.TermsAndConditions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;


public class TestDataInputFromSource extends TestEnvironment {

    @Test
    @Epic("Registration")
    @Description("Sequential registration using data from JSON file.")
    @DisplayName("TC04 Sequential Registration Using Data From JSON File Test")
    @Severity(SeverityLevel.NORMAL)
    public void sequentialRegistrationUsingDataFromJSONFile() throws InterruptedException, IOException, ParseException {

        TermsAndConditions termsAndConditions = new TermsAndConditions(driver);
        termsAndConditions.navigate();

        Thread.sleep(300);
        termsAndConditions.clickOnAcceptButton();

        Register register = new Register(driver);

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("registerData.json");
        Object object = jsonParser.parse(reader);
        JSONArray registerUserList = (JSONArray) object;
        for (int i=0; i<registerUserList.size(); i++) {
            JSONObject usersOfJSON = (JSONObject) registerUserList.get(i);
            JSONObject user = (JSONObject) usersOfJSON.get("users");
            String username = (String) user.get("username");
            String password = (String) user.get("password");
            String email = (String) user.get("email");
            String description = (String) user.get("description");

            //Register
            register.makeNewRegistration(username, password, email, description);  //benne van a Register tab és Register button is
            Thread.sleep(300);
            makeScreenshot("Registration_" + i + "_screenshot");

            String expectedRegisterResult = "User registered!";
            String actualRegisterResult = register.registerMessageResult();
            Assertions.assertEquals(expectedRegisterResult, actualRegisterResult);

            //Login
            Login login = new Login(driver);
            login.navigateToLoginTab();
            login.loginWithData(username, password);
            makeScreenshot("Login_" + i + "_screenshot");

            String expectedLoginResult = "Logout";
            String actualLoginResult = login.findLogoutButton();
            Assertions.assertEquals(expectedLoginResult, actualLoginResult);

            login.pushLogoutButton();
        }

    }

}
