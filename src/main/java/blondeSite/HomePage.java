package blondeSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private final String URL = "https://lennertamas.github.io/blondesite/landing.html";

    private final By findPostTitles = By.xpath("//*[@class='text-gray-900 font-bold text-xl mb-2 dark:text-white']");

    private final By findPostCards = By.xpath("//*[@class='relative pl-4 p-2 justify-between leading-normal max-w-full w-full']");

    private final By findNextPageLink = By.xpath("//*[@rel='next']");

    //konstruktor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.navigate().to(URL);
    }

    public void clickOnNextButton() {
        driver.findElement(findNextPageLink).click();
    }

    public boolean clickableNextArrow() {
        boolean arrowButton = driver.findElement(findNextPageLink).getAttribute("rel").equals("next");
        if (arrowButton == true) {
            clickOnNextButton();
        }
        return false;
    }

    //elemszámot adja vissza egy oldalon
    public int getTitlesNumberOnOnePage() {
        return driver.findElements(findPostTitles).size();
    }

    //megadja az összes poszt számát
    public int getPostTitlesSum() {
        int totalRecords = 0;
        do {
            totalRecords += getTitlesNumberOnOnePage();
        } while (clickableNextArrow());
        totalRecords += getTitlesNumberOnOnePage();  //utolsó oldalon levő posztokat is hozzászámolja
        return totalRecords;
    }

    public String[] getTitles() {

        List<WebElement> titles = driver.findElements(findPostCards);
        List<String> titleList = new ArrayList<String>();

        //TODO oldal lapozás!!

        for (WebElement title : titles) {
            String postTitle = title.findElement(By.xpath("./div[1]")).getText();
            titleList.add(postTitle);
        }

        //String listából String tömbbé alakít
        String[] result = new String[getPostTitlesSum()];
        result = titleList.toArray(result);
        return result;


    }
}
