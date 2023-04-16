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

    //Tags

    //private final By findTagsBlock = By.xpath("//div[@class='panel-block p-2']");
    private final By findTags = By.xpath("//div[@class='panel-block p-2']/a");
    private final By findCssTag = By.xpath("//a[@href='/blondesite/tags/css']");
    private final By findEmojiTag = By.xpath("//a[@href='/blondesite/tags/emoji']");
    private final By findHtmlTag = By.xpath("//a[@href='/blondesite/tags/html']");
    private final By findMarkdownTag = By.xpath("//a[@href='/blondesite/tags/markdown']");
    private final By findPrivacyTag = By.xpath("//a[@href='/blondesite/tags/privacy']");
    private final By findShortcodesTag = By.xpath("//a[@href='/blondesite/tags/shortcodes']");
    private final By findTextTag = By.xpath("//a[@href='/blondesite/tags/text']");
    private final By findThemesTag = By.xpath("//a[@href='/blondesite/tags/themes']");

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

    //Find tags
    public void findCssTag(){
        driver.findElement(findCssTag);
    }
    public void findEmojiTag(){
        driver.findElement(findEmojiTag);
    }
    public void findHtmlTag(){
        driver.findElement(findHtmlTag);
    }
    public void findMarkdownTag(){
        driver.findElement(findMarkdownTag);
    }
    public void findPrivacyTag(){
        driver.findElement(findPrivacyTag);
    }
    public void findShortcodesTag(){
        driver.findElement(findShortcodesTag);
    }
    public void findTextTag(){
        driver.findElement(findTextTag);
    }
    public void findThemesTag(){
        driver.findElement(findThemesTag);
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

    //megadja az összes különböző tag számát
    public int getTagsNumberSum() {
        return driver.findElements(findTags).size();
    }

    //Title-ket szedi ki egy String tömbbe
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

    //Tag-eket szedi ki egy String tömbbe
    public String[] getTags() {
        List<WebElement> tags = driver.findElements(findTags);
        List<String> tagsList = new ArrayList<String>();

        for (WebElement tag : tags) {
            String tagTitle = tag.findElement(By.xpath("./span[1]")).getText();
            tagsList.add(tagTitle);
        }

        //String listából String tömbbé alakít
        String[] result = new String[getTagsNumberSum()];
        result = tagsList.toArray(result);
        return result;
    }
}
