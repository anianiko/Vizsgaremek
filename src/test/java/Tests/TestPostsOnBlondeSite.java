package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestPostsOnBlondeSite extends TestEnvironment {


    /*
    @Test
    @Epic("Posts")
    @Description("We check the post titles in a txt file.")
    @DisplayName("TC15 Checking post titles test")
    @Severity(SeverityLevel.NORMAL)
    public void comparePostTitlesWithTxtTest(){

        loginWithNewRegistration(Constans.USERNAME, Constans.PASSWORD, Constans.EMAIL, Constans.DESCRIPTION);

        HomePage homePage = new HomePage(driver);

        List<String> resultList = new ArrayList<>();

        do{
            homePage.getTitles(resultList);
            if(!homePage.isClickableNextArrow()){
                break;
            }
            homePage.clickOnNextButton();
        } while (true);

        List<String> actualResultList = new ArrayList<>();
        actualResultList = resultList;

        //String listából String tömbbé alakít
        String[] actualResult = new String[actualResultList.size()];
        actualResult = actualResultList.toArray(actualResult);
        String[] expectedResult = ReadTxtFile("postTitles.txt");
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

     */

    @Test
    @Epic("Posts")
    @Description("We count the posts on the Blonde site.")
    @DisplayName("TC14 Counting post titles test")
    @Severity(SeverityLevel.NORMAL)
    public void countPostTitlesTest() {

        loginWithNewRegistration(Constans.USERNAME, Constans.PASSWORD, Constans.EMAIL, Constans.DESCRIPTION);

        HomePage homePage = new HomePage(driver);

        int totalRecords = 0;

        do {
            totalRecords += homePage.getTitlesNumberOnOnePage();
        } while (homePage.clickableNextArrow());
        totalRecords += homePage.getTitlesNumberOnOnePage();  //utolsó oldalon levő posztokat is hozzászámolja

        int actualResult = totalRecords;
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);
    }


}
