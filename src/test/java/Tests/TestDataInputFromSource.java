package Tests;

import TestEnvironment.TestEnvironment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class TestDataInputFromSource extends TestEnvironment {

    @Test
    @Epic("Registration")
    @Description("Sequential registration using data from JSON file.")
    @DisplayName("Sequential Registration Using JSON File Test")
    @Severity(SeverityLevel.NORMAL)
    public void sequentialRegistrationUsingDataFromJSONFile(){
        //TODO
    }

}
