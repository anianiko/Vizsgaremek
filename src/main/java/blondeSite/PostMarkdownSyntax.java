package blondeSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PostMarkdownSyntax extends BasePage {

    private final String URL= "https://lennertamas.github.io/blondesite/post/markdown-syntax/";

    private final By TableRows = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div/table[1]/tbody/tr");


    //konstruktor
    public PostMarkdownSyntax(WebDriver driver) {
        super(driver);
    }



    public void navigate() {
        driver.navigate().to(URL);
    }

    public String[] getNamesFromTable() {
        List<WebElement> tableRows = driver.findElements(TableRows);
        String[] nameListFromTable;
        nameListFromTable = new String[tableRows.size()];
        for (int i = 0; i < tableRows.size(); i++) {
            WebElement tableData = tableRows.get(i).findElement(By.xpath("./td[1]"));  //a sorok 1.eleme (cellája)
            nameListFromTable[i] = tableData.getText();
        }
        return nameListFromTable;
    }

    public String[] getAgesFromTable() {
        List<WebElement> tableRows = driver.findElements(TableRows);
        String[] ageListFromTable;
        ageListFromTable = new String[tableRows.size()];
        for (int i = 0; i < tableRows.size(); i++) {
            WebElement tableData = tableRows.get(i).findElement(By.xpath("./td[2]")); //a sorok 2.eleme (cellája)
            ageListFromTable[i] = tableData.getText();
        }
        return ageListFromTable;
    }

}
