package Pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class BrokenImagesLinks {
    String url = "https://demoqa.com/broken";
    WebDriver driver;

    By images = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/img");
    By links = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/a");
    By selectButton = By.id("item-6");

    public BrokenImagesLinks(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public List getImages() {
        return driver.findElements(images);
    }

    public List getLinks() {
        return driver.findElements(links);
    }

    public void getSelectButton() {
        driver.findElement(selectButton).click();
    }

}
