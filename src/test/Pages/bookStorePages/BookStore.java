package Pages.bookStorePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookStore {
    String url = "https://demoqa.com/books";
    WebDriver driver;

    By selectButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]/span");
    By searchBox = By.id("searchBox");
    By login = By.id("login");
    By images = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/img");
    By bookLinks = By.className("rt-tr-group");

    By addNewRecordButton = By.id("addNewRecordButton");
    public BookStore(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public WebElement getSelectButton() {
        return driver.findElement(selectButton);
    }

    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    public WebElement getLogin() {
        return driver.findElement(login);
    }

    public List getImages() {
        return driver.findElements(images);
    }

    public WebElement getBookLinks() {
        return driver.findElement(bookLinks);
    }

    public List<WebElement> getTextFromColumns() {
        return driver.findElements(bookLinks);
    }

    public List<WebElement> getAddNewRecordButton() {
        return driver.findElements(addNewRecordButton);
    }

    public void selectFromBookListText(String text) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> list = getTextFromColumns();

        driver.findElement(By.xpath("//a[text()='"+text+"']")).click();
    }

    //Back to store + add to collection button // 0-back to store 1-Add to collection
    public void backAddCollection(int i){
        List<WebElement> buttonList = getAddNewRecordButton();
        buttonList.get(i).click();
    }
}
