package Pages.elementsPages;

import BasePagePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IndexPage {
    WebDriver driver;
    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    By logo_image = By.xpath("//*[@id=\"app\"]/header/a/img");
    By content = By.className("banner-image");
    By elements = By.className("card-body");


    public WebElement getLogo_image() {
        return driver.findElement(logo_image);
    }
    public WebElement getContent() {
        return driver.findElement(content);
    }
    public List<WebElement> listElements() {
        return driver.findElements(elements);
    }

    public void selectAnElement(int index){
        List<WebElement> webElementsList = listElements();
        webElementsList.get(index).click();
    }
}
