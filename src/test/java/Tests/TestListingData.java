package Tests;

import TestEnvironment.TestEnvironment;
import blondeSite.MarkdownSyntax;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestListingData extends TestEnvironment {

    //kiolvassa egy string tömbbe a txt sorait
    public String[] ReadNamesFile() {
        List<String> names = new ArrayList<>();
        try {
            File text = new File("namesFromTable.txt");
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

    @Test
    @Epic("Table data")
    @Description("We compare names from table with txt file.")
    @Severity(SeverityLevel.NORMAL)
    public void getNamesFromTableTest() {

        String USERNAME = "Anna";
        String PASSWORD = "mammamia123";
        String EMAIL = "cool@code.com";
        String DESCRIPTION = "Tester";

        //TestEnvironmentbe kiemelt reg+login metódus
        loginWithNewRegistration(USERNAME, PASSWORD, EMAIL, DESCRIPTION);

        MarkdownSyntax markdownSyntax = new MarkdownSyntax(driver);

        markdownSyntax.navigate();
        String[] actualResult = markdownSyntax.getNamesFromTable();
        String[] expectedResult = ReadNamesFile();

        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    @Epic("Table data")
    @Description("We compare ages from table with test data.")
    @Severity(SeverityLevel.NORMAL)
    public void getAgesFromTableTest() {

        String USERNAME = "Anna";
        String PASSWORD = "mammamia123";
        String EMAIL = "cool@code.com";
        String DESCRIPTION = "Tester";

        //TestEnvironmentbe kiemelt reg+login metódus
        loginWithNewRegistration(USERNAME, PASSWORD, EMAIL, DESCRIPTION);

        MarkdownSyntax markdownSyntax = new MarkdownSyntax(driver);

        markdownSyntax.navigate();
        String[] actualResult = markdownSyntax.getAgesFromTable();
        String[] expectedResult = {"27", "23"};

        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

}
