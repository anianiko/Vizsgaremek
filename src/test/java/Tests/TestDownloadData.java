package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.PostImageTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestDownloadData extends TestEnvironment {

    @Test
    @Epic("Download data")
    @Description("Save a picture from the Image test post.")
    @DisplayName("Save picture test")
    @Severity(SeverityLevel.NORMAL)
    public void savePictureTest() throws IOException, InterruptedException {

        //TODO fájltörlést betesz (if-fel) a post class-jába

        loginWithNewRegistration(Constans.USERNAME, Constans.PASSWORD, Constans.EMAIL, Constans.DESCRIPTION);

        PostImageTest postImageTest = new PostImageTest(driver);
        postImageTest.navigate();
        Thread.sleep(1000); //InterruptedException-t kell betenni a teszt metódusba
        postImageTest.savePicture();  //a savePicture() miatt IOException-t kell betenni a teszt metódusba is

        //csekkolja, hogy létezik-e a letöltött fájl
        boolean actualResult = postImageTest.checkPictureSaveResult();
        Assertions.assertTrue(actualResult);

    }



}
