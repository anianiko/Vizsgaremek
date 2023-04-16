package blondeSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PostImageTest extends BasePage{

    private final String URL = "https://lennertamas.github.io/blondesite/post/image-test/";

    private final By findPrismPicture = By.xpath("//*[@class='py-4']");

    private final String savePictureName = "prism.jpg";

    //konsktruktor
    public PostImageTest(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.navigate().to(URL);
    }

    public void savePicture() throws IOException {
        WebElement findPicture = driver.findElement(findPrismPicture);
        String srcPicture = findPicture.getAttribute("src");
        java.net.URL pictureURL = new URL(srcPicture);
        BufferedImage saveImage = ImageIO.read(pictureURL);
        ImageIO.write(saveImage, "jpg", new File(savePictureName));
    }

    //ellenőrzi, hogy létezik-e a projekt mappájában a megadott nevű fájl
    public boolean checkPictureSaveResult() {
        File savedFile = new File(savePictureName);
        return savedFile.exists();
    }

    public void deletePicture(){
        //TODO

    }

}
