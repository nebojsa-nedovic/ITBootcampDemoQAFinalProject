package Pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Links {
    public String url = "https://demoqa.com/links";
    WebDriver driver;
    public Links(WebDriver driver){
        this.driver = driver;
    }
    By listOfLinks = By.xpath("//*[@id='linkWrapper']/p/a");
    By selectLinks = By.id("item-5");
    public By addtionaltext = By.id("linkResponse");

    public String getUrl() {
        return url;
    }
    public List<WebElement> listOfLinks(){
        return driver.findElements(listOfLinks);
    }
    public void getSelectLinks() {
        driver.findElement(selectLinks).click();
    }
    public WebElement getAddtionaltext() {
         return driver.findElement(addtionaltext);
    }

    public void selectLink(int index){
        List<WebElement> webElementsList = listOfLinks();
        webElementsList.get(index).click();
    }
    public String windowTabs(){
        //get window handlers as list
        List<String> tabList = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(tabList.get(1));
        //check is it correct page opened or not (e.g. check page's title)
        String pageUrl = driver.getCurrentUrl();
        //then close tab and get back
        driver.close();
        driver.switchTo().window(tabList.get(0));
        return pageUrl;
    }
}
