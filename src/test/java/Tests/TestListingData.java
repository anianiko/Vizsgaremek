package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.HomePage;
import blondeSite.PostMarkdownSyntax;
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

public class TestListingData extends TestEnvironment {

    /*
    //kiolvassa egy string tömbbe a megadott txt fájl sorait
    public String[] ReadTxtFile(String filename) {
        List<String> names = new ArrayList<>();
        try {
            File text = new File(filename);
            Scanner nameScan = new Scanner(text);
            while (nameScan.hasNextLine()) {
                String name = nameScan.nextLine();
                names.add(name);
            }
        } catch (Exception e) {
            System.out.println("File not found.");
        }
        return names.toArray(new String[0]);
    }

     */

    @Test
    @Epic("Table data")
    @Description("We compare names from table with txt file.")
    @DisplayName("TC08 Get names from table test")
    @Severity(SeverityLevel.NORMAL)
    public void getNamesFromTableTest() {

        loginWithNewRegistration(Constans.USERNAME, Constans.PASSWORD, Constans.EMAIL, Constans.DESCRIPTION);

        PostMarkdownSyntax markdownSyntax = new PostMarkdownSyntax(driver);

        markdownSyntax.navigate();
        String[] actualResult = markdownSyntax.getNamesFromTable();
        String[] expectedResult = ReadTxtFile("namesFromTable.txt");

        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    @Epic("Table data")
    @Description("We compare ages from table with test data.")
    @DisplayName("TC09 Get ages from table test")
    @Severity(SeverityLevel.NORMAL)
    public void getAgesFromTableTest() {

        loginWithNewRegistration(Constans.USERNAME, Constans.PASSWORD, Constans.EMAIL, Constans.DESCRIPTION);

        PostMarkdownSyntax markdownSyntax = new PostMarkdownSyntax(driver);

        markdownSyntax.navigate();
        String[] actualResult = markdownSyntax.getAgesFromTable();
        String[] expectedResult = {"27", "23"};

        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    @Epic("Tags")
    @Description("We compare tags from BlondeSite with txt file.")
    @DisplayName("TC10 Get tags from BlondeSite test")
    @Severity(SeverityLevel.NORMAL)
    public void getTagsFromBlondeSiteTest() {

        loginWithNewRegistration(Constans.USERNAME, Constans.PASSWORD, Constans.EMAIL, Constans.DESCRIPTION);

        HomePage homePage = new HomePage(driver);

        homePage.navigate();
        String[] actualResult = homePage.getTags();
        String[] expectedResult = ReadTxtFile("tagList.txt");

        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

}
