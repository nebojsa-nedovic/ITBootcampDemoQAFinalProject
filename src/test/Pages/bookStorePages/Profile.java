package Pages.bookStorePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Profile{
    String url="https://demoqa.com/profile";
    WebDriver driver;

    By selectButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]");
    By listItems = By.className("action-buttons");
    By deleteButton = By.id("delete-record-undefined");
    By cancelButton = By.id("closeSmallModal-cancel");
    By okButton = By.id("closeSmallModal-ok");
    public Profile(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public WebElement getSelectButton() {
        return driver.findElement(selectButton);
    }

    public WebElement getCancelButton() {
        return driver.findElement(cancelButton);
    }

    public WebElement getOkButton() {
        return driver.findElement(okButton);
    }
    public List<WebElement> getListItems() {
        return driver.findElements(listItems);
    }

    public List<WebElement> getDeleteButton() {
        return driver.findElements(deleteButton);
    }


    //Array collection with name and bin element // method only counts links
    public int listLength(){
        int size = getListItems().size();
        return size/2;
    }

    public void deleteItem(int index){
        List<WebElement> list = getDeleteButton();
        list.get(index).click();
    }



}
